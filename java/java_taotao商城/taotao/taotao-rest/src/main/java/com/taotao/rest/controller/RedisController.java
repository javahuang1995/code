package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.rest.service.RedisService;

/**
 * 缓存同步Controller
 * <p>Title: RedisController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月9日下午3:47:18
 * @version 1.0
 * 这里是同步缓存，需要手动同步，想办法搞一个定时任务和一个按钮让他同步一下。
 * httpAPI是:/rest/cache/sync/content/89,是写死的。
 * 89是大广告位，反正只用到了大广告，也只有打广告位用了缓存。
 */
@Controller
@RequestMapping("/cache")
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	/**
	 * 同步缓存，就是把缓存项目都删掉就完事了。
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sync")
	public TaotaoResult cacheSync() {
		TaotaoResult result = redisService.syncContent();
		return result;
	}
	
//	@RequestMapping("/content/{contentCid}")
//	@ResponseBody
//	public TaotaoResult contentCacheSync(@PathVariable Long contentCid) {
//		TaotaoResult result = redisService.syncContent(contentCid);
//		return result;
//	}
}
