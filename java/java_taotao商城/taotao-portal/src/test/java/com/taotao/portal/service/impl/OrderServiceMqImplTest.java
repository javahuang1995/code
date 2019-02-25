package com.taotao.portal.service.impl;

import com.taotao.pojo.Order;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class OrderServiceMqImplTest
{
    //idea会自动提示你注入失败，检查之后发现是xml要全部导入进来。
    @Autowired
    private OrderServiceMqImpl orderServiceMQImpl;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void createOrder()
    {
        //创建一个对象，作为测试对象。。都是空的。。
        Order order = new Order();
        order.setOrderId("1");
        order.setPayment("card");
        List tbOrderItemList = new ArrayList<TbOrderItem>();
        tbOrderItemList.add(new TbOrderItem());
        order.setOrderItems(tbOrderItemList);

        TbOrderShipping tbOrderShipping = new TbOrderShipping();
        tbOrderShipping.setCreated(new Date());
        tbOrderShipping.setOrderId("2");
        tbOrderShipping.setReceiverName("huang");

        order.setOrderShipping(tbOrderShipping);


        //模拟双十一大量订单产生
        for (int i = 0; i < 100000; i++)
        {
            //发送发送发送发送发送发送射射射射！！！！
            orderServiceMQImpl.createOrder(order);
        }


    }
}