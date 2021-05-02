package com.jz.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.jz.dao.CustomerDao;
import com.jz.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	//ʹ�����߲�ѯ�����߲�ѯֻ��Criteria�У� ����ѯ�ܵļ�¼��
	public Integer getTotalCount(DetachedCriteria dc) {
		//�����ߵ�Criteria��ӾۺϺ���
		dc.setProjection(Projections.rowCount());
		//ʹ��Hibernateģ�����Criteriaִ�У�hibernateģ���ڲ��Ѿ����Session  ��������Criteriaִ��ʱ ģ���Ѿ���Session��ִ�У�
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//���Criteria�ڵľۺϺ������Թ���������ʹ�����ߵ�Criteria��ǰ��İ�Sessionֻ����ģ���ڲ�����
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
