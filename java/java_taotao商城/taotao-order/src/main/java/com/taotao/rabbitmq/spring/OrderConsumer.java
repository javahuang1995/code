package com.taotao.rabbitmq.spring;

import com.taotao.common.utils.JsonUtils;
import com.taotao.order.pojo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/24 22:22
 * @Description:
 */
public class OrderConsumer implements MessageListener
{
    private Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    public void orderListen(Order order){


    }

    @Override
    public void onMessage(Message message)
    {
        //这里就是业务逻辑处理，就是插入数据到数据库就完事了，不用返回什么东西。。
        logger.info("generate order ...");
        message.getBody();
    }
}
