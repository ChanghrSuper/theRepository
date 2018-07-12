package com.chr.dao;

import com.chr.entity.User;

public interface UserDao {

	User selectByUsername(String username);
	
	void insertUser(User user);
}
