package com.huang.webservice.test;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

    public static void main(String[] args) {
        System.out.println("web service start");
        HelloWorld implementor = new HelloWorldImpl();
        String address = "http://localhost:8080/hello/ws";

        JaxWsServerFactoryBean sf = new JaxWsServerFactoryBean();
        sf.setAddress(address); // 设置暴露地址
        sf.setServiceClass(HelloWorld.class); // 接口类
        sf.setServiceBean(implementor); // 设置实现类
        sf.create(); // 创建webservice接口
        System.out.println("web service started");
        System.out.println("请求地址为为：" + address + "?WSDL");
    }
}
