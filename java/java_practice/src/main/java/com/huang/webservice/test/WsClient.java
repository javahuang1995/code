package com.huang.webservice.test;
 
public class WsClient {
 
	public static void main(String[] args) {

		HelloWorldService s = new HelloWorldService();
		HelloWorld h = s.getHelloWorldPort();
		
		String result = h.sayHello("sdfk");
		
		System.out.println(result);
		
		
	}
 
}
