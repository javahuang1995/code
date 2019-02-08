package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.search.service.ItemService;

/**
 * 索引库维护
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月11日下午2:50:45
 * @version 1.0
 */
@Controller
@RequestMapping("/manager")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	/**
	 * 导入商品数据到索引库
	 * 如果商品数据内容发生改变，重新执行一下这个url就可以了。
	 * http://www.taotao.com:8083/search/manager/importall
	 */
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importAllItems() {
		TaotaoResult result = itemService.importAllItems();
		return result;
	}
	
	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	@ResponseBody
	public TaotaoResult deleteAll() {
		try {
			return itemService.deleteAll();
		} catch (Exception e) {
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
