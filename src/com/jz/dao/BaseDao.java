package com.jz.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	//增
	void save(T t);
	//删
	void delete(T t);
	//删(根据id删除   因为不确定id的类型，Serializable是所有基本类型的超类)
	void delete(Serializable id);
	//改
	void update(T t);	
	//查（根据id查）
	T getById(Serializable id);
	//查（符合条件的总记录数   条件为离线查询）
	Integer getTotalCount(DetachedCriteria dc);
	//查（查询分页列表数据）
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
