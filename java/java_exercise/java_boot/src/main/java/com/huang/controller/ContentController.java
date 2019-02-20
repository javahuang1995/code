package com.huang.controller;

import com.huang.common.pojo.EUDataGridResult;
import com.huang.common.pojo.TaotaoResult;
import com.huang.pojo.TbContent;
import com.huang.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 内容管理Controller
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月8日上午11:13:52
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContent(Long ids) {
		TaotaoResult result = contentService.deleteContent(ids);
		return result;
	}
	
	
/*	@RequestMapping("/query/list/{categoryId}")
	@ResponseBody
	public TbContent getItemList(@PathVariable long categoryId) {
		TbContent result = contentService.getItemById(categoryId);
		return result;
	} */
	
	@RequestMapping(value="/query/list", method=RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult getItemList(@RequestParam(defaultValue="89")Long categoryId, Integer page, Integer rows) {
		EUDataGridResult result = contentService.getItemList(categoryId,page, rows);
		return result;
	} 
}
