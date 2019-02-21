package com.huang.base.test.mytest;

import java.net.URLDecoder;

import org.junit.Test;

public class MyTest {
	
	@Test
	public void myTest() throws Exception{
		System.out.println("fuck");
		String cookie = "%5B%7B%22id%22%3A1458729469%2C%22title%22%3A%22%E6%B5%B7%E5%B0%94%EF%BC%88Haier%EF%BC%89HM-M209%E6%89%8B%E6%9C%BA+%E8%80%81%E4%BA%BA%E6%9C%BA+%E8%80%81%E4%BA%BA%E6%89%8B%E6%9C%BA+%E8%80%81%E5%B9%B4%E6%89%8B%E6%9C%BA+%E7%9B%B4%E6%9D%BF%E6%89%8B%E6%9C%BA+%E7%BA%A2%E8%89%B2%22%2C%22num%22%3A123%2C%22price%22%3A19900%2C%22image%22%3A%22http%3A%2F%2Fimage.taotao.com%2Fcommon.jpg%22%7D%5D";
		String retValue = URLDecoder.decode(cookie, "UTF-8");
		
		System.out.println(retValue);
	}

}
