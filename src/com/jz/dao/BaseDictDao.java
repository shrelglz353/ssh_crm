package com.jz.dao;

import java.util.List;

import com.jz.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {
	
	List<BaseDict> getListByTypeCode(String dict_type_code);
}
