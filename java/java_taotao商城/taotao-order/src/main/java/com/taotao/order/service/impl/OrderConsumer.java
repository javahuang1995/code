package com.taotao.order.service.impl;

import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 *
 */

public class OrderConsumer implements MessageListener
{
    private Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    public void hello()
    {
        logger.info("hello");
    }

    @Override
    public void onMessage(Message message)
    {
        //这里就是业务逻辑处理，就是插入数据到数据库就完事了，不用返回什么东西。。
        logger.info("generate order ...");
        try
        {
            Order order = (Order) getObjectFromBytes(message.getBody());
            logger.info("order info is :"+JsonUtils.objectToJson(order));
            //insert into db
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("get order error!!!!!");
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
