package com.jz.service;

import java.util.List;

import com.jz.domain.BaseDict;

public interface BaseDictService {
	//����dict_type_code�ĵ�BaseDict
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
