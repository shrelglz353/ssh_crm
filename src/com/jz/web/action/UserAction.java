package com.jz.web.action;

import com.jz.domain.User;
import com.jz.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private UserService userService;

	private User user = new User();
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String  login() {
		User user2 = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", user2);
		return "toHome";
	}

	@Override
	public User getModel() {
		return user;
	}

}