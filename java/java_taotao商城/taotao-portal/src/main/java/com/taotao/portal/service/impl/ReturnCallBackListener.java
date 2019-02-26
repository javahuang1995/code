package com.taotao.portal.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Service;
/**
 *
 * @Auther:宁哥
 * @param:发送消息失败，将进入此回调方法
 * exchange到queue失败, 则回调return
 * (需设置mandatory = true, 否则不回回调, 消息就丢了)
 */

@Service("returnCallBackListener")
public class ReturnCallBackListener implements ReturnCallback
{

    private static final Logger logger = LoggerFactory.getLogger(ReturnCallBackListener.class);

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey)
    {
        logger.error("扑街，发送消息失败。。");
        logger.error("return--message:"+new String(message.getBody())+",replyCode:"+replyCode+",replyText:"+replyText+",exchange:"+exchange+",routingKey:"+routingKey);
    }
}