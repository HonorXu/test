package com.honor.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.honor.biz.BookBiz;
import com.honor.biz.BookTypeBiz;
import com.honor.model.Book;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookBiz bookBiz;
	@Autowired
	private BookTypeBiz bookTypeBiz;

	@RequestMapping(value = "/list")
	@ResponseBody
	public String list() {
		List<Book> list = bookBiz.findAll();
		// List<BookType> list = bookTypeBiz.findAll();
		System.out.println(JSON.toJSONString(list));
		return JSON.toJSONString(list);
	}

	@RequestMapping(value = "/add")
	public void add() throws IOException {

		Integer id = 1003078;
		String url = "https://api.douban.com/v2/book/";
		for (int i = 0; i < 50; i++) {
			CloseableHttpClient http = HttpClients.createDefault();
			HttpGet get = new HttpGet(url + (id + (int) (Math.random() * 1000)));
			CloseableHttpResponse response = http.execute(get);
			String str;
			try {
				HttpEntity entity = response.getEntity();
				str = EntityUtils.toString(entity);
				logger.info(response.getStatusLine().toString());
				logger.info(str);
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
			JSONObject obj = (JSONObject) JSONObject.parse(str);
			Book b = bookBiz.findByIsbn(obj.getString("isbn10"));
			if (b != null || obj.get("author")==null )	
				break;
			Book book = new Book();
			book.setAuthor(obj.getJSONArray("author").get(0).toString());
			book.setAuthorIntro(obj.getString("author_intro"));
			book.setBinding(obj.getString("binding"));
			book.setBookBorrowed(0);
			book.setBookTotal((int) (Math.random() * 10 + 1));
			book.setBorrowTimes(0);
			book.setCoverPic(obj.getString("image"));
			book.setIsbn(obj.getString("isbn10"));
			book.setPages(obj.getInteger("pages"));
			book.setPrice(getNum(obj.getString("price")));
			book.setPublishDate(parse(obj.getString("pubdate")));
			book.setPublisher(obj.getString("publisher"));
			book.setStatus(1);
			book.setSubtitle(obj.getString("subtitle"));
			book.setSummary(obj.getString("summary"));
			book.setTitle(obj.getString("title"));
			book.setTypeId(1);
			int a = bookBiz.add(book);
			System.out.println(a);
		}
	}

	/**
	 * 获取字段中的第一个数字
	 * 
	 * @param str
	 * @return double
	 */
	public static Double getNum(String str) {
		Pattern p = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
		String temp = "";
		Matcher m = p.matcher(str);
		if (m.find()) {
			temp = m.group(1);
		}

		return Double.valueOf(temp);
	}

	public static LocalDate parse(String str) {
		String[] s = str.split("\\-|\\/");
		int year = Integer.valueOf(s[0]);
		int month = Integer.valueOf(s[1]);
		int day = s.length > 2 ? Integer.valueOf(s[2]) : 1;
		return LocalDate.of(year, month, day);
	}
}
