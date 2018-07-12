package com.chr.dao;

import com.chr.entity.User;

public interface UserDao {
    void insert(User user);
    User selectByUsername(String username);
}
