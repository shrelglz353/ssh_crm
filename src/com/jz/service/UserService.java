package com.jz.service;

import com.jz.domain.User;

public interface UserService {
	
	//��¼
	User getUserByCodePassword(User u);
	//ע���û�
	void saveUser(User u);
}
