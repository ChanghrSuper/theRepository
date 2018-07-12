package com.chr.service;

import com.chr.entity.Orders;

public interface OrderService {

    void addOrderFromProduct(String userid, Orders orders);

    void addOrderFromShoppingCar(String userid, String[] proids);
}
