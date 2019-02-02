package com.taotao.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

/**
 * 商品分类列表
 * <p>
 * Title: ItemCatController
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 这里是展示商品目录，也就是动态首页的商品分类信息那个功能
 * 因为前端是直接在页面上通过js调用访问这个http接口的，所以这就有js跨域访问的问题
 * 所以用到了mappingjaksonvalue这个东东，实际上，如果前端不用js调用，用httpclient调用，就没这个鸟问题了。
 * 其实这里也可以用缓存，以后改写一下。
 * @author 入云龙
 * @date 2015年9月7日下午3:02:39
 * @version 1.0
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	private static Logger LOG = Logger.getLogger(ItemCatController.class);

	/*
	 * @RequestMapping(value="/itemcat/list",
	 * produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	 * 
	 * @ResponseBody public String getItemCatList(String callback) { CatResult
	 * catResult = itemCatService.getItemCatList(); //把pojo转换成字符串 String json =
	 * JsonUtils.objectToJson(catResult); //拼装返回值 String result = callback + "("
	 * + json + ");"; return result; }
	 */
	@RequestMapping("/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		CatResult catResult = itemCatService.getItemCatList();
		LOG.info("catResult is"+catResult);
		//跨域调用，要用MappingJacksonValue！
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
}
