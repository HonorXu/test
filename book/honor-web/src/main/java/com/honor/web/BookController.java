package com.honor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.honor.biz.BookBiz;
import com.honor.model.Book;

@Controller
@RequestMapping(value="/book")
public class BookController {
	@Autowired
	private BookBiz bookBiz;
	
	@RequestMapping(value="/list")
	@ResponseBody
	public String list() {
		List<Book> list = bookBiz.findAll();
		System.out.println(JSON.toJSONString(list));
		return JSON.toJSONString(list);
	}
}
