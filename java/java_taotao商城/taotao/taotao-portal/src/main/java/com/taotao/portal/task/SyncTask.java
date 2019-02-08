package com.taotao.portal.task;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;

@Component
public class SyncTask extends TimerTask {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	private static final Logger logger = LoggerFactory.getLogger(SyncTask.class);

	private ServletContext application = null;
	
	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		String json = HttpClientUtil.doGet(REST_BASE_URL + "/cache/sync");
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TaotaoResult.class);
		if (taotaoResult.getStatus() != 200) {
			logger.info("SyncTask execute Fail,Exception:" + taotaoResult.getMsg());
		} else {
			logger.info("SyncTask execute Successfull!");
		}
	}

}
