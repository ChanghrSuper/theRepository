package com.chr.service;

import com.chr.entity.Address;
import com.chr.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(String id);

    void add(User user);

    void remove(String id);

    void modify(User user);

    List<Address> findAddr(String userid);

    void addAddr(Address addr);

    void delAddr(String id);

    User findByUsernamePassword(User user);

}
