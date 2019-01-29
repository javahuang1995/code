package com.taotao.service;


import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

	TaotaoResult insertContent(TbContent content);
	public TbContent getItemById(long itemId);
	EUDataGridResult getItemList(Long categoryId,int page, int rows);
	public TaotaoResult deleteContent(Long ids);

}
