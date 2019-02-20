package com.taotao.service;


import com.huang.common.pojo.EUDataGridResult;
import com.huang.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
	TaotaoResult deleteItemParam(long ids);
	
	EUDataGridResult getItemParamList(int page, int rows);
	
}
