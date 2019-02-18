package com.huang.service;

import com.huang.common.pojo.EUTreeNode;
import com.huang.common.pojo.TaotaoResult;

import java.util.List;


public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
	TaotaoResult updateContentCategory(long id, String name);
	TaotaoResult deleteContentCategory(long id);
}
