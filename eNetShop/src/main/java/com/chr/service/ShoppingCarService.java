package com.chr.service;

import com.chr.entity.Shoppingcar;

import java.util.List;

public interface ShoppingCarService {

    void add(String userid, Shoppingcar shoppingcar);

    List<Shoppingcar> findAll(String userid);

    void changeNum(String proid, Integer num, String userid);

    void remove(String userid, String proid);
}
