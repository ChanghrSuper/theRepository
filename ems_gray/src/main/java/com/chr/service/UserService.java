package com.chr.service;

import com.chr.entity.User;

public interface UserService {

	User findByUsernameAndPassword(User user);
	
	void addUser(User user);

	Boolean findUsername(String name);
}
