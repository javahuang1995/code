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
 * 消息手动签收
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
            logger.info("order info is :" + JsonUtils.objectToJson(order));

            //insert into db
            orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());

        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("insert order error!!!!!");
            //如果消息处理失败，应该将消息放回队列中，也就是NACK重回队列
            //第三个参数为是否重返队列
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
        finally
        {
            //手动回执，相当于买东西要签收快递一样，手动签收快递，确认收货。
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
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
