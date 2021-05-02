package com.jz.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jz.dao.CustomerDao;
import com.jz.domain.Customer;
import com.jz.service.CustomerService;
import com.jz.utils.PageBean;
//◊¢Ω‚≈‰÷√aop ¬ŒÒ
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;

	@Override
	public PageBean getPageBean(DetachedCriteria dc,Integer currentPage, Integer pageSize) {
		int totalCount = cd.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		pb.setList(list);
		return pb;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

}
