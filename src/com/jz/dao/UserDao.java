package com.jz.dao;

import com.jz.domain.User;

public interface UserDao {
	
	//���ݵ�¼���Ʋ�ѯuser����
	User getByUserCode(String userCode);
	//����user����
	void save(User u);

}
