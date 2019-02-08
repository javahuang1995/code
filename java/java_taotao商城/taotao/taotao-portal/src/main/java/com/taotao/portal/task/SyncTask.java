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

	@Value("${REST_SYNC_URL}")
	private String REST_SYNC_URL;

	@Value("${SEARCH_SYNC_URL}")
	private String SEARCH_SYNC_URL;
	
	private static final Logger logger = LoggerFactory.getLogger(SyncTask.class);

	private ServletContext application = null;
	
	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}
	/**
	 * 这是定时任务，刷新缓存，包括2个地方
	 * 1.清空redis缓存
	 * 2.重新导入solr索引数据。
	 */
	@Override
	public void run() {
		String json = HttpClientUtil.doGet(REST_SYNC_URL);
		String json2 =HttpClientUtil.doGet(SEARCH_SYNC_URL);
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TaotaoResult.class);
		TaotaoResult taotaoResult2 = TaotaoResult.formatToPojo(json2, TaotaoResult.class);
		if (taotaoResult.getStatus() == 200 && taotaoResult2.getStatus() == 200)
		{
			logger.info("SyncTask execute Successfull!");
		} 
		else 
		{
			logger.info("SyncTask execute Fail,Exception:" + taotaoResult.getMsg());
		}
	}

}
