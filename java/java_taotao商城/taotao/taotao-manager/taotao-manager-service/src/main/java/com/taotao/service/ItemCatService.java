package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
	TaotaoResult addItemCat(long parentId, String name);
	TaotaoResult deleteItemCat(long id);
	TaotaoResult updateIetmCat(long id, String name);
}
