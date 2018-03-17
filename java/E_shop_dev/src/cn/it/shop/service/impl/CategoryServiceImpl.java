package cn.it.shop.service.impl;

import java.util.List;

import org.hibernate.*;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.utils.HibernateSessionFactory;

/**
 * @Description TODO（模块自身的业务逻辑）
 * @author Ni Shengwu
 * 
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements
		CategoryService {
	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Category> queryJoinAccount(String type) {
	// String hql2 = "from Category c where c.type like :type";//会有1+N问题
	// String hql =
	// "from Category c left join fetch c.account where c.type like :type";
	// return getSession().createQuery(hql)
	// .setString("type", "%" + type + "%").list();
	// }

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		String hql = "from Category c left join fetch c.account where c.type like :type";
		return getSession().createQuery(hql)
				.setString("type", "%" + type + "%")
				.setFirstResult((page - 1) * size) // 从第几个开始显示
				.setMaxResults(size) // 显示几个
				.list();
	}

}