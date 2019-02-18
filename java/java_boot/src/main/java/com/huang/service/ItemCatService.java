package com.huang.service;

import com.huang.common.pojo.EUTreeNode;
import com.huang.common.pojo.TaotaoResult;

import java.util.List;



public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
	TaotaoResult addItemCat(long parentId, String name);
	TaotaoResult deleteItemCat(long id);
	TaotaoResult updateIetmCat(long id, String name);
}
