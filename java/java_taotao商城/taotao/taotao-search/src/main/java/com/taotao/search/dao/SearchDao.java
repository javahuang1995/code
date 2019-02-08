package com.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
