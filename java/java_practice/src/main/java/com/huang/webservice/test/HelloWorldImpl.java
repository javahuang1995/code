package com.huang.webservice.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
//����ʵ����
@WebService
public class HelloWorldImpl implements HelloWorld{

	@WebMethod
    public String sayHello(String str) {
        return "Hello" + str;
    }

}
