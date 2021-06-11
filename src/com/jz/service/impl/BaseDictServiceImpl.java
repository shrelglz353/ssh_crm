package com.jz.service.impl;

import java.util.List;

import com.jz.dao.BaseDictDao;
import com.jz.domain.BaseDict;
import com.jz.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDao bdd;

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return bdd.getListByTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

	public BaseDictDao getBdd() {
		return bdd;
	}
	

}
