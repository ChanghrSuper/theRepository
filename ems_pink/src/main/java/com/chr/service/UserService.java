package com.chr.service;

import com.chr.entity.User;

public interface UserService {

    void save(User user);
    User findByUsernamePassword(User user);
}
