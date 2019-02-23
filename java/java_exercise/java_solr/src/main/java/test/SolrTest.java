package test;//package com.huang.solr.test;
//
//import java.util.List;
//
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.common.SolrDocument;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.solr.common.SolrInputDocument;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.taotao.mapper.ItemMapper;
//import com.taotao.pojo.Item;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
//public class SolrTest {
//
//	private static final Logger logger = LoggerFactory.getLogger(SolrTest.class);
//	@Autowired
//	private SolrServer solrServer;
//	@Autowired
//	private ItemMapper itemMapper;
//
//	/**
//	 * 这里就是涉及到2个操作
//	 * 1.把数据从数据库里面读出来
//	 * 2.读出来的数据上传到solr服务器里面。就完事了。
//	 */
//	@Test
//	public void testImport() {
//		try {
//
//			// 查询商品列表
//			List<Item> list = itemMapper.getItemList();
//			// 把商品信息写入索引库
//			for (Item item : list) {
//				// 创建一个SolrInputDocument对象
//				SolrInputDocument document = new SolrInputDocument();
//				document.setField("id", item.getId());
//				document.setField("item_title", item.getTitle());
//				document.setField("item_sell_point", item.getSell_point());
//				document.setField("item_price", item.getPrice());
//				document.setField("item_image", item.getImage());
//				document.setField("item_category_name", item.getCategory_name());
//				document.setField("item_desc", item.getItem_des());
//				// 写入索引库
//				solrServer.add(document);
//			}
//			// 提交修改
//			solrServer.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testQuery() {
//
//		// 创建查询对象
//		SolrQuery query = new SolrQuery();
//		String queryString = "a";
//		int page = 1;
//		int rows = 10;
//
//		// 设置查询条件
//		query.setQuery(queryString);
//
//		// 设置分页
//		query.setStart((page - 1) * rows);
//		query.setRows(rows);
//		// 设置默认搜素域
//		query.set("df", "item_keywords");
//		// 设置高亮显示
//		query.setHighlight(true);
//		query.addHighlightField("item_title");
//		query.setHighlightSimplePre("<em style=\"color:red\">");
//		query.setHighlightSimplePost("</em>");
//
//		// 根据查询条件查询索引库
//		QueryResponse queryResponse = null;
//		try {
//			queryResponse = solrServer.query(query);
//		} catch (SolrServerException e) {
//			e.printStackTrace();
//		}
//
//		// 取查询结果
//		SolrDocumentList solrDocumentList = queryResponse.getResults();
//		// 取查询结果总数量
//		long num = solrDocumentList.getNumFound();
//		// 取商品列表
//		for (SolrDocument solrDocument : solrDocumentList) {
//			StringBuffer sb = new StringBuffer();
//			sb.append(solrDocument.get("item_title")).append("-");
//			sb.append(solrDocument.get("item_image")).append("-");
//			sb.append(solrDocument.get("item_price")).append("-");
//			sb.append(solrDocument.get("item_sell_point")).append("-");
//			sb.append(solrDocument.get("item_category_name")).append("-");
//			logger.info(sb.toString());
//		}
//
//	}
//
//}
