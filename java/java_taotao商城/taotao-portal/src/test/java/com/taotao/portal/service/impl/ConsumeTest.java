package com.taotao.portal.service.impl;

import com.rabbitmq.client.*;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.Order;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/25 18:51
 * @Description:
 */
public class ConsumeTest
{
    public static void main(String[] args) throws IOException, TimeoutException
    {
        Connection connection = MyConnectionUtil.getFactory().newConnection();
        final Channel channel = connection.createChannel();
        channel.queueBind("orderQueue", "taotaoExchange", "order");

        //定义一个消费者
        Consumer consumer = new DefaultConsumer(channel)
        {
            //消息到达 触发这个方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException
            {

                //这里有个问题，就是需要把字节流转换成对象。
                ByteArrayInputStream bi = new ByteArrayInputStream(body);
                ObjectInputStream oi = new ObjectInputStream(bi);

                try
                {
                    Order order = (Order)oi.readObject();
                    Thread.sleep(2000);
                    System.out.println(JsonUtils.objectToJson(order));
                }
                catch (InterruptedException | ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    //不管有没有异常，都会执行finally，这里手动回执channel.basicAck
                    System.out.println("[1] done ");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        boolean autoAck = false;//自动应答 false
        channel.basicConsume("orderQueue", autoAck, consumer);

    }
}
