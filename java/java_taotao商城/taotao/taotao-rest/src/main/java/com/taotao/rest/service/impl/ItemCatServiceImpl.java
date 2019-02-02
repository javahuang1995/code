package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

/**
 * 商品分类服务
 * <p>
 * Title: ItemCatServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 入云龙
 * @date 2015年9月7日下午2:44:41
 * @version 1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_ITEMCAT_KEY}")
	private String REDIS_ITEMCAT_KEY;

	@Override
	public CatResult getItemCatList() {

		CatResult catResult = new CatResult();
		// 查询分类列表
		catResult.setData(getCatList(0));// 这里传入parent_id为0，表示顶层商品目录，我们要取的就是顶层商品目录，可以调用sql查一下。
		return catResult;
	}

	/**
	 * 查询分类列表
	 * <p>
	 * Title: getCatList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param parentId
	 * @return
	 */
	private List<?> getCatList(long parentId) {
		List<TbItemCat> list = null;// 从缓存或者数据库中取内容
		List resultList = new ArrayList<>();// 这是前台需要的数据，也是我们返回的数据。
		try {
			String result = jedisClient.hget(REDIS_ITEMCAT_KEY, parentId + "");// 加上""的意义就是把其他数据类型转换成String
			if (!StringUtils.isBlank(result)) {
				// 把字符串转换成list
				list = JsonUtils.jsonToList(result, TbItemCat.class);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//如果缓存里面取不到
		if (list == null || list.size() == 0) {
			// 创建查询条件
			TbItemCatExample example = new TbItemCatExample();
			Criteria criteria = example.createCriteria();
			criteria.andParentIdEqualTo(parentId);
			// 执行查询
			list = itemCatMapper.selectByExample(example);// 这是查出来的数据

			// 添加到缓存
			try {
				// 把list转换成字符串
				String cacheString = JsonUtils.objectToJson(list);
				jedisClient.hset(REDIS_ITEMCAT_KEY, parentId + "", cacheString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 向list中添加节点
		int count = 0;
		for (TbItemCat tbItemCat : list) {
			// 判断是否为父节点
			if (tbItemCat.getIsParent()) {
				CatNode catNode = new CatNode();
				if (parentId == 0) {
					catNode.setName(
							"<a href='/products/" + tbItemCat.getId() + ".html'>" + tbItemCat.getName() + "</a>");
				} else {
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products/" + tbItemCat.getId() + ".html");
				catNode.setItem(getCatList(tbItemCat.getId()));

				resultList.add(catNode);
				count++;
				// 第一层只取14条记录
				if (parentId == 0 && count >= 14) {
					break;
				}
				// 如果是叶子节点
			} else {
				resultList.add("/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName());
			}
		}
		return resultList;
	}

}
