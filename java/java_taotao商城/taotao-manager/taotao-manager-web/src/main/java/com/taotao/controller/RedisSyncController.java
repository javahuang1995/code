package com.taotao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;

@Controller
@RequestMapping("/cache")
public class RedisSyncController {

	/**
	 * 同步缓存，就是把缓存项目都删掉就完事了。
	 * @return
	 */
	private static final Logger logger = LoggerFactory.getLogger(RedisSyncController.class);

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_SYNC_URL}")
	private String REST_SYNC_URL;
	
	@ResponseBody
	@RequestMapping("/sync")
	public TaotaoResult cacheSync() {
		String url = REST_BASE_URL+REST_SYNC_URL;
		logger.info(url);
		String json = HttpClientUtil.doGet(url);
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TaotaoResult.class);
		logger.info("success");
		return taotaoResult;
	}
	
//	@RequestMapping("/content/{contentCid}")
//	@ResponseBody
//	public TaotaoResult contentCacheSync(@PathVariable Long contentCid) {
//		TaotaoResult result = redisService.syncContent(contentCid);
//		return result;
//	}
}
