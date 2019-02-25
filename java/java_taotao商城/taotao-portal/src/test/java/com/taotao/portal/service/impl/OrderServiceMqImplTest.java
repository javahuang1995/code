package com.taotao.portal.service.impl;

import com.taotao.portal.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class OrderServiceMqImplTest
{
    //idea会自动提示你注入失败，检查之后发现是xml要全部导入进来。
    @Autowired
    private OrderServiceMqImpl orderServiceMQImpl;

    @Test
    public void createOrder()
    {
        Order order = new Order();
        order.setOrderId("dd");
        orderServiceMQImpl.createOrder(order);
    }
}