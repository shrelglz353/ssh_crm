package com.jz.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jz.domain.Customer;

public interface CustomerDao {
	//得到总记录数
	Integer getTotalCount(DetachedCriteria dc);
	//得到分页的数据
	List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
