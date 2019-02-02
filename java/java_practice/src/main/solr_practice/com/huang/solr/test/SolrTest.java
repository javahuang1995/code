package com.huang.solr.test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-solr.xml")
public class SolrTest {

	private static final Logger logger = LoggerFactory.getLogger(SolrTest.class);
	@Autowired
	private SolrServer solrServer;

	@Test
	public void testQuery() {

		// 创建查询对象
		SolrQuery query = new SolrQuery();
		String queryString = "a";
		int page = 1;
		int rows = 10;

		// 设置查询条件
		query.setQuery(queryString);

		// 设置分页
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		// 设置默认搜素域
		query.set("df", "item_keywords");
		// 设置高亮显示
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");

		// 根据查询条件查询索引库
		QueryResponse queryResponse = null;
		try {
			queryResponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}

		// 取查询结果
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		// 取查询结果总数量
		long num = solrDocumentList.getNumFound();
		// 取商品列表
		for (SolrDocument solrDocument : solrDocumentList) {
			StringBuffer sb = new StringBuffer();
			sb.append(solrDocument.get("item_title")).append("-");
			sb.append(solrDocument.get("item_image")).append("-");
			sb.append(solrDocument.get("item_price")).append("-");
			sb.append(solrDocument.get("item_sell_point")).append("-");
			sb.append(solrDocument.get("item_category_name")).append("-");
			logger.info(sb.toString());
		}

	}

}
