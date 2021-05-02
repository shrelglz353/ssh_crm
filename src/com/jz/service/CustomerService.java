package com.jz.service;

import org.hibernate.criterion.DetachedCriteria;

import com.jz.domain.Customer;
import com.jz.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
