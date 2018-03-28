package com.honor.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于HttpClient封装的HTTP请求工具<br>
 * 
 * 可以通过配置CookieStore对cookie进行管理<br>
 * 
 * 可以通过配置RequestConfig对请求的超时等进行配置<br>
 * 
 * @author vran
 *
 */
public class HttpUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	private static final String DEFAULT_CHARSET = "UTF-8";

	private CookieStore cookieStore;

	private RequestConfig requestConfig;

	private CloseableHttpClient http;

	public static HttpUtils http() {
		return new HttpUtils(false, null, null);
	}

	public static HttpUtils http(CookieStore cookieStore) {
		return new HttpUtils(false, cookieStore, null);
	}

	public static HttpUtils http(RequestConfig requestConfig) {
		return new HttpUtils(false, null, requestConfig);
	}

	public static HttpUtils http(CookieStore cookieStore, RequestConfig requestConfig) {
		return new HttpUtils(false, cookieStore, requestConfig);
	}

	public static HttpUtils https() {
		return new HttpUtils(true, null, null);
	}

	public static HttpUtils https(CookieStore cookieStore) {
		return new HttpUtils(true, cookieStore, null);
	}

	public static HttpUtils https(RequestConfig requestConfig) {
		return new HttpUtils(true, null, requestConfig);
	}

	public static HttpUtils https(CookieStore cookieStore, RequestConfig requestConfig) {
		return new HttpUtils(true, cookieStore, requestConfig);
	}

	/**
	 * 加载证书 TODO
	 * 
	 * @param file
	 * @return
	 */
	private static HttpUtils https(File file) {
		return null;
	}

	private HttpUtils(boolean isHttps, CookieStore cookieStore, RequestConfig requestConfig) {
		this.cookieStore = cookieStore == null ? new BasicCookieStore() : cookieStore;
		this.requestConfig = requestConfig == null ? RequestConfig.DEFAULT : requestConfig;
		HttpClientBuilder builder = HttpClients.custom();
		if (isHttps) {
			builder.setSSLSocketFactory(configDefaultSSL());
		}
		builder.setDefaultCookieStore(this.cookieStore);
		builder.setDefaultRequestConfig(this.requestConfig);
		this.http = builder.build();
	}

	public String postJSON(String url, String json) {
		return postJSON(url, json, DEFAULT_CHARSET);
	}

	public String postJSON(String url, String json, String charset) {
		return doPost(url, json, null, ContentType.APPLICATION_JSON.withCharset(charset));
	}

	public String postJSON(String url, String json, Map<String, String> headers, String charset) {
		return doPost(url, json, headers, ContentType.APPLICATION_JSON.withCharset(charset));
	}

	public String postXML(String url, String xml) {
		return postXML(url, xml, DEFAULT_CHARSET);
	}

	public String postXML(String url, String xml, String charset) {
		return doPost(url, xml, null, ContentType.APPLICATION_XML.withCharset(charset));
	}

	public String postXML(String url, String xml, Map<String, String> headers, String charset) {
		return doPost(url, xml, headers, ContentType.APPLICATION_XML.withCharset(charset));
	}

	public String post(String url, Map<String, String> params) {
		return post(url, params, DEFAULT_CHARSET);
	}

	public String post(String url, Map<String, String> params, String charset) {
		return doPost(url, params, null, charset);
	}

	public String post(String url, Map<String, String> params, Map<String, String> headers, String charset) {
		return doPost(url, params, headers, charset);
	}

	public String get(String url) {
		HttpGet get = new HttpGet(url);
		return executeAndReturn(get);
	}

	/**
	 * TODO
	 * 
	 * @param url
	 * @return
	 */
	public String delete(String url) {
		HttpDelete delete = new HttpDelete(url);
		return executeAndReturn(delete);
	}

	/**
	 * 
	 * TODO
	 * 
	 * @param url
	 * @return
	 */
	public String put(String url) {
		HttpPut put = new HttpPut(url);
		return executeAndReturn(put);
	}

	public CookieStore getCookieStore() {
		return this.cookieStore;
	}

	private String doPost(String url, Map<String, String> params, Map<String, String> headers, String charset) {
		HttpPost post = new HttpPost(url);
		List<NameValuePair> list = new ArrayList<>();
		if (params != null) {
			for (Entry<String, String> entry : params.entrySet())
				list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));

		}

		configHeaders(post, headers);

		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
			post.setEntity(entity);
			return executeAndReturn(post);
		} catch (UnsupportedEncodingException e) {
			logger.error("编码 " + charset + " 错误," + e.getMessage());
		}
		return null;
	}

	private String doPost(String url, String content, Map<String, String> headers, ContentType contentType) {
		HttpPost post = new HttpPost(url);
		configHeaders(post, headers);
		ByteArrayEntity entity = new ByteArrayEntity(content.getBytes(contentType.getCharset()), contentType);
		post.setEntity(entity);
		return executeAndReturn(post);
	}

	private String executeAndReturn(HttpRequestBase request) {
		try {
			CloseableHttpResponse resp = http.execute(request);
			String str = EntityUtils.toString(resp.getEntity());
			logger.info("请求响应状态:" + resp.getStatusLine().getStatusCode() + "\r\n 响应结果: " + str);
			return str;
		} catch (ClientProtocolException e) {
			logger.error("请求异常: " + e.getMessage(), e);
		} catch (IOException e) {
			logger.error("", e);
		}
		return null;
	}

	private void configHeaders(HttpRequestBase request, Map<String, String> headers) {
		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				request.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 默认的HTTPS配置 忽略证书校验
	 * 
	 * @return
	 */
	private SSLConnectionSocketFactory configDefaultSSL() {
		SSLContext sslContxt = null;
		try {
			sslContxt = SSLContextBuilder.create().loadTrustMaterial((charin, authType) -> true).build();
		} catch (Exception e) {
			logger.error("配置SSL异常:" + e.getMessage());
		}
		final SSLConnectionSocketFactory sslcf = new SSLConnectionSocketFactory(sslContxt, (hostName, session) -> true); // 配置https认证
		return sslcf;
	}

	/**
	 * TODO
	 * 
	 * @param file
	 * @return
	 * 
	 */
	@SuppressWarnings("unused")
	private SSLConnectionSocketFactory configSSLWithFile(File file) {
		return null;
	}

}
