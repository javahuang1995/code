package com.huang.mq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/23 20:11
 * @Description:AMQP协议 这里可以用单例+工厂模式，
 * 单例来获取工厂对象，工厂获取连接对象。
 */
public class ConnectionUtil
{

    private static String HOST = "localhost";
    private static String VHOST = "/vhost";
    private static int PORT = 5672;
    private static String USER = "huang";
    private static String PASS = "1995";

    private volatile static   ConnectionFactory connectionFactory;

    public static  ConnectionFactory getFactory()
    {
        if (connectionFactory == null)
        {
            synchronized (ConnectionUtil.class)
            {
                if (connectionFactory == null)
                {
                    connectionFactory = new ConnectionFactory();
                }
            }
        }
        connectionFactory.setHost(HOST);
        connectionFactory.setPort(PORT);
        connectionFactory.setVirtualHost(VHOST);
        connectionFactory.setUsername(USER);
        connectionFactory.setPassword(PASS);

        return  connectionFactory;

    }


}
