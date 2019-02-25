package com.taotao.portal.service.impl;

import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这里发送订单消息给中间件，做一个解耦的测试。
 */
@Service
public class OrderServiceMqImpl implements OrderService
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String createOrder(Order order)
    {
        //这个地方如何保证发送成功？？
        rabbitTemplate.convertAndSend(order);
        return "success";

    }

}