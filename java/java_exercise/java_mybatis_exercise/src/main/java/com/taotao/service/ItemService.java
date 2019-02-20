package com.taotao.service;


import com.huang.common.pojo.EUDataGridResult;
import com.huang.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
	
	TaotaoResult updateItem(TbItem item, String desc, String itemParam) throws Exception;
	TaotaoResult deleteItem(Long ids);

}
