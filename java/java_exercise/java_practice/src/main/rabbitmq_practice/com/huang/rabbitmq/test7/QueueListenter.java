package com.huang.rabbitmq.test7;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.huang.common.utils.JsonUtils;

public class QueueListenter implements MessageListener {
	private static final Logger LOG = LoggerFactory.getLogger(QueueListenter.class);

	@Override
	public void onMessage(Message msg) {
		try {
			String get  = new String(msg.getBody(), "UTF-8");
			LOG.info("监听器输出" + get);
			Map<String, Object> bodyMap = JsonUtils.jsonToPojo(get, Map.class);
			LOG.info(bodyMap.get("batchNo").toString());
			LOG.info(bodyMap.get("item").toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}