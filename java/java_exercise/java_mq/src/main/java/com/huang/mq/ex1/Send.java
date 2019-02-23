package com.huang.mq.ex1;

import com.huang.mq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/23 20:15
 * @Description:
 */
public class Send
{
    private static final String QUEUE = "queue1";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        Connection connection = ConnectionUtil.getFactory().newConnection();

        Channel channel = connection.createChannel();

        boolean durable = false;
        channel.queueDeclare(QUEUE,durable, false, false, null);

        String msg = "fuck you ";

        channel.basicPublish("", QUEUE, null, msg.getBytes());
        System.out.println("Send : has send msg:"+msg);

        //发送完毕之后，需要关闭。
        channel.close();
        connection.close();


    }
}
