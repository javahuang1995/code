package com.huang.webservice.test;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

    public static void main(String[] args) {
        System.out.println("web service start");
        HelloWorld implementor = new HelloWorldImpl();
        String address = "http://localhost:8080/hello/ws";

        JaxWsServerFactoryBean sf = new JaxWsServerFactoryBean();
        sf.setAddress(address); // ���ñ�¶��ַ
        sf.setServiceClass(HelloWorld.class); // �ӿ���
        sf.setServiceBean(implementor); // ����ʵ����
        sf.create(); // ����webservice�ӿ�
        System.out.println("web service started");
        System.out.println("�����ַΪΪ��" + address + "?WSDL");
    }
}
