package com.jz.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.jz.dao.BaseDictDao;
import com.jz.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict>implements BaseDictDao {

	private Logger logger = LogManager.getLogger(BaseDictDaoImpl.class);

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		//���߲�ѯ
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		//��Ӳ�ѯ����
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		//ִ�в�ѯ
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		logger.fatal(list);
		return list;
	}
}
