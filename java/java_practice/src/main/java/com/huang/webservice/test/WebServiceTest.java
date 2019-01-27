package com.huang.webservice.test;

import org.apache.http.client.HttpClient;

public class WebServiceTest {
	/**
	 * @Description get方式请求
	 * @param number
	 * @throws Exception
	 */
	public void get(String number) throws Exception {
		// HttpClient：在java代码中模拟Http请求

		// 创建浏览器对象
		HttpClient client = new HttpClient();
		// 填写数据，发送get或者post请求
		GetMethod get = new GetMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx"
				+ "/getMobileCodeInfo?mobileCode=" + number + "&userID=");
		// 指定传输的格式为get请求格式
		get.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
		// 发送请求
		int code = client.executeMethod(get);
		System.out.println("Http:状态码为：" + code);

		String result = get.getResponseBodyAsString();
		System.out.println("返回的结果为：" + result);
	}

	/**
	 * @Description post方式请求
	 * @param number
	 * @throws Exception
	 */
	public void post(String number) throws Exception {
		// HttpClient：在java代码中模拟Http请求
		// 创建浏览器对象
		HttpClient client = new HttpClient();
		// 填写数据，发送get或者post请求
		PostMethod post = new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");

		// 指定传输的格式为默认post格式
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		// 传输参数
		post.setParameter("mobileCode", number);
		post.setParameter("userID", "");

		// 发送请求
		int code = client.executeMethod(post);
		System.out.println("Http:状态码为：" + code);

		String result = post.getResponseBodyAsString();
		System.out.println("返回的结果为：" + result);
	}

	/**
	 * @Description soap post方式请求，但是传输的数据为xml格式，有利于数据的维护
	 * @param number
	 * @throws Exception
	 */
	public void soap(String number) throws Exception {
		// HttpClient：在java代码中模拟Http请求
		// 创建浏览器对象
		HttpClient client = new HttpClient();
		// 填写数据，发送get或者post请求
		PostMethod post = new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");

		// 指定传输的格式为xml格式
		post.setRequestHeader("Content-Type", "application/soap+xml;charset=utf-8");
		// 传输xml，加载soap.txt
		post.setRequestBody(new FileInputStream("E:/github/client/src/soap.txt"));
		// 发送请求
		int code = client.executeMethod(post);
		System.out.println("Http:状态码为：" + code);

		String result = post.getResponseBodyAsString();
		// 如果采用的是soap，则返回的数据也是基于xml的soap格式
		System.out.println("返回的结果为：" + result);
	}

}
