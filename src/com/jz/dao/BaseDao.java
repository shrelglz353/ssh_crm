package com.jz.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//��
	void save(T t);
	//ɾ
	void delete(T t);
	//ɾ(����idɾ��   ��Ϊ��ȷ��id�����ͣ�Serializable�����л������͵ĳ���)
	void delete(Serializable id);
	//��
	void update(T t);	
	//�飨����id�飩
	T getById(Serializable id);
	//�飨�����������ܼ�¼��   ����Ϊ���߲�ѯ��
	Integer getTotalCount(DetachedCriteria dc);
	//�飨��ѯ��ҳ�б����ݣ�
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
