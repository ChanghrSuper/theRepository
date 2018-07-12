package com.chr.service;

import com.chr.entity.Products;

import java.util.List;

public interface ProductsService {

    void save(Products products);
    void remove(String id);
    void modify(Products products);
    List<Products> find(String name);
    Products findOne(String id);
}
