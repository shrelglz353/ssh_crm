package com.jz.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.jz.dao.CustomerDao;
import com.jz.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	//使用离线查询（离线查询只有Criteria有） 来查询总的记录数
	public Integer getTotalCount(DetachedCriteria dc) {
		//给离线的Criteria添加聚合函数
		dc.setProjection(Projections.rowCount());
		//使用Hibernate模板调用Criteria执行（hibernate模板内部已经解决Session  所以离线Criteria执行时 模板已经绑定Session后执行）
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空Criteria内的聚合函数，以供后续继续使用离线的Criteria（前面的绑定Session只是在模板内部，）
		dc.setProjection(null);
		
		if(list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	@Override
	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

}
