package com.chr.dao;

import com.chr.entity.Products;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductsDao {

    void insert(Products products);
    void delete(String id);
    void update(Products products);
    List<Products> select(@Param("name") String name);
    Products selectOne(String id);
}
