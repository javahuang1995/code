package com.shop.dao.impl;

import com.shop.dao.CategoryDao;
import com.shop.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO（模块自身的业务逻辑）
 * @author Ni Shengwu
 *
 */
@SuppressWarnings("unchecked")
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	/*
	 * 这里的分页查询解释一下
	 * page表示第几页，size表示显示几个
	 * setFirstResult表示从第几个开始显示， 那肯定就是(page-1)*size
	 * setMaxResult表示显示几个 显示size个。size定义了每个page的大小。
	 * 例如queryJoinAccount(type,2,10)表示查询第二个page,每个page是10个。
	 * @see cn.it.shop.dao.CategoryDao#queryJoinAccount(java.lang.String, int, int)
	 */
	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		String hql = "from Category c left join fetch c.account where c.type like :type";
		return getSession().createQuery(hql)
				.setString("type", "%" + type + "%")
				.setFirstResult((page-1) * size) //从第几个开始显示
				.setMaxResults(size) //显示几个
				.list();
	}

	@Override
	public Long getCount(String type) {
		String hql = "select count(c) from Category c where c.type like :type";
		return (Long) getSession().createQuery(hql)
			.setString("type", "%" + type + "%")
			.uniqueResult(); //返回一条记录:总记录数
	}

	@Override
	public void deleteByIds(String ids) {
		String hql = "delete from Category c where c.id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		String hql = "from Category c where c.hot=:hot";
		return getSession().createQuery(hql)
			.setBoolean("hot", hot)
			.list();
	}
}
