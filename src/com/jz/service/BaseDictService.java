package com.jz.service;

import java.util.List;

import com.jz.domain.BaseDict;

public interface BaseDictService {
	//根据dict_type_code的到BaseDict
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
