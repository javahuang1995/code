package com.taotao.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.RedisService;

/**
 * 这里刷新缓存直接把redis里面的数据删除就行了，因为取数据的时候会把自己读取到的最新值更新到redis
 * @author huang
 *
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_CONTENT_KEY}")
	private String REDIS_CONTENT_KEY;
	
	@Value("${REDIS_ITEMCAT_KEY}")
	private String REDIS_ITEMCAT_KEY;
	
	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;

	
	@Override
	public TaotaoResult syncContent() {
		try {
			//jedisClient.hdel(REDIS_CONTENT_KEY, contentCid + "");
			jedisClient.del(REDIS_CONTENT_KEY);//用del删除整个哈希表
			jedisClient.del(REDIS_ITEMCAT_KEY);//用del删除整个哈希表
			
			jedisClient.del(REDIS_ITEM_KEY+"_BASE");
			jedisClient.del(REDIS_ITEM_KEY+"_DESC");
			jedisClient.del(REDIS_ITEM_KEY+"_PARAM");
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

}
