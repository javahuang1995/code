package com.taotao.portal.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

/**
 * @Auther:宁哥
 * @desc:发送消息成功，消息确认监听器 如果消息到达exchange, 则confirm回调, ack=true
 * 如果消息没有到exchange,则confirm回调,ack=false
 */

@Service("confirmCallBackListener")
public class ConfirmCallBackListener implements ConfirmCallback
{

    private static final Logger logger = LoggerFactory.getLogger(ConfirmCallBackListener.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack)
    {
        if (ack)
        {
            logger.info("恭喜,消息成功发送到队列broker里面啦");
        }
    }
}