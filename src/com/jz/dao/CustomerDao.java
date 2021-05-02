package com.jz.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jz.domain.Customer;

public interface CustomerDao {
	//�õ��ܼ�¼��
	Integer getTotalCount(DetachedCriteria dc);
	//�õ���ҳ������
	List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
