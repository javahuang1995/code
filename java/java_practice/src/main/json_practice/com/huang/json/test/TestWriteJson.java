package com.huang.json.test;

import java.io.IOException;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huang.json.test.JSONCaseA;

public class TestWriteJson {

	@Test
	public void writeJson() throws JsonProcessingException,IOException  {

		ObjectMapper mapper = new ObjectMapper();

		JSONCaseA case1 = new JSONCaseA();
		case1.setCity("BeiJing");

		case1.setUnknownAttr("testVal");
		case1.setAge(123);

		//�����ǽ��������л���json
		String jsonStr = mapper.writeValueAsString(case1);
		System.out.println("JSON:" + jsonStr);
		
		//�����ǽ�jsonת���ɶ���
		String inputjsonstr = "{\"city\":\"BeiJing\",\"testa\":123}";
		JSONCaseA readcase = mapper.readValue(inputjsonstr, JSONCaseA.class);
		System.out.println("object info:" + readcase);

		

	}
}
