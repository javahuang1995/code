package com.taotao.order.service.impl;

import com.rabbitmq.client.Channel;
import com.taotao.common.utils.JsonUtils;
import com.taotao.order.service.OrderService;
import com.taotao.pojo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 *
 */

public class OrderConsumer2 implements ChannelAwareMessageListener
{
    private Logger logger = LoggerFactory.getLogger(OrderConsumer2.class);

    @Autowired
    private OrderService orderService;

    public void hello()
    {
        logger.info("hello");
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception
    {
        //这里就是业务逻辑处理，就是插入数据到数据库就完事了，不用返回什么东西。。
        logger.info("generate order ...");
        try
        {
            Order order = (Order) getObjectFromBytes(message.getBody());
            logger.info("order info is :"+JsonUtils.objectToJson(order));

            //insert into db
            orderService.createOrder(order,order.getOrderItems(),order.getOrderShipping());

        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("get order error!!!!!");
        }finally
        {
            //手动回执
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }
    }


    public Object getObjectFromBytes(byte[] objBytes) throws Exception
    {
        if (objBytes == null || objBytes.length == 0)
        {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }


}
