package com.huang.webservice.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
//这是实现类
@WebService
public class HelloWorldImpl implements HelloWorld{

	@WebMethod
    public String sayHello(String str) {
        return "Hello" + str;
    }

}
