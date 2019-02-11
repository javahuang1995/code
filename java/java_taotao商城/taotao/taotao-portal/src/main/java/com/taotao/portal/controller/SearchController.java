package com.taotao.portal.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.portal.pojo.SearchResult;
import com.taotao.portal.service.SearchService;

/**
 * 商品搜索Controller
 * <p>Title: SearchController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月12日上午9:21:34
 * @version 1.0
 * 这里有个问题，就是q如果为空，那么会报空指针。。
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	/**
	 * 
	 * @param queryString 查询String 比如手机
	 * @param page        查询第几页，默认查询第一页，如果要翻页的话，就是传入2,3,4。。
	 * @param model       这个就是model。。。。
	 * @return
	 */
	@RequestMapping("/search")
	public String search(@RequestParam("q")String queryString, @RequestParam(defaultValue="1")Integer page, Model model) {
		if (queryString != null) {
			try {
				queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		SearchResult searchResult = searchService.search(queryString, page);
		//向页面传递参数
		model.addAttribute("query", queryString);
		
		//查询条件为空的时候，会报空指针，加上判空指针。。
		if(searchResult != null){
			model.addAttribute("totalPages", searchResult.getPageCount());
			model.addAttribute("itemList", searchResult.getItemList());
		}
		
		model.addAttribute("page", page);
		
		return "search";
		
	}
}
