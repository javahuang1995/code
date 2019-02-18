package com.huang.service;



import com.huang.common.pojo.EUDataGridResult;
import com.huang.common.pojo.TaotaoResult;
import com.huang.pojo.TbContent;

public interface ContentService {

	TaotaoResult insertContent(TbContent content);
	public TbContent getItemById(long itemId);
	EUDataGridResult getItemList(Long categoryId, int page, int rows);
	public TaotaoResult deleteContent(Long ids);

}
