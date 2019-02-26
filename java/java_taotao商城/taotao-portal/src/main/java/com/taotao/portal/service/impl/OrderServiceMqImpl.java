package com.taotao.portal.service.impl;

import com.taotao.pojo.Order;
import com.taotao.portal.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这里发送订单消息给中间件，做一个解耦的测试。
 * 需要保证，消息一定送到RabbitMQ中。不会丢失。
 */
@Service
public class OrderServiceMqImpl implements OrderService
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Logger logger = LoggerFactory.getLogger(OrderServiceMqImpl.class);

    @Override
    public String createOrder(Order order)
    {
        //为了保证高可用，我们还可以先把消息发送到redis,
        //如果消息发送成功，我们就把消息从redis里面删除，如果发送失败，redis里面至少还有数据。

        //这个地方如何保证发送成功？？
        //如果交换机找不到对应消息的队列，或者找不到队列，就会丢掉消息，因为交换机无法存储消息的。
        rabbitTemplate.convertAndSend("order",order);

        logger.info("convertAndSend Ok");
        return "success";

    }

}