package com.shop.dao.impl;

import com.shop.dao.SorderDao;
import com.shop.model.Sorder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sorderDao")
@SuppressWarnings("unchecked")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements
		SorderDao {
	
	@Override
	public List<Object> querySale(int number) {
		//不用fecth查出来的就是两项
		String hql = "select s.name, sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql) //
			.setFirstResult(0) //
			.setMaxResults(number) //
			.list();
	}
}
