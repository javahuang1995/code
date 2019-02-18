package com.huang.controller;

import java.util.List;

import com.huang.MainApp;
import com.huang.common.pojo.EUTreeNode;
import com.huang.common.pojo.TaotaoResult;
import com.huang.service.ContentCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 内容分类管理
 * <p>Title: ContentCategoryController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月8日上午9:23:41
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentCategoryController {

	private static final Logger LOG = LoggerFactory.getLogger(ContentCategoryController.class);

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/category/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
		return list;
	}
	
	@RequestMapping("/category/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name) {
		TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	
	/**
	 * 重命名
	 * 之前写成了下面这样，结果404，所以注意最后不能添加斜杠
	 * @RequestMapping("/category/update/")
	 */
	@RequestMapping("/category/update")
	@ResponseBody
	public TaotaoResult updateContentCategory(Long id,String name){
		LOG.info("fuck you ");
		TaotaoResult result = contentCategoryService.updateContentCategory(id, name);
		return result;
	}
	
	
	/**
	 * 删除 出现空指针错误。。。
	 * http://www.taotao.com:8080/content/category/delete?parentId=96&id=97
	 */
	@RequestMapping("/category/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(@RequestParam("id")Long id){
		LOG.info("start deleteContentCategory....");
		TaotaoResult result = contentCategoryService.deleteContentCategory(id);
		return result;
	}
	

	
	
	
}
