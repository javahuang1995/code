
package com.huang.webservice.test;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorld {

	@WebMethod
	public String sayHello(String str);
}
