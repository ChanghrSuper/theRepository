package com.chr.service;

import com.chr.entity.Product;
import com.chr.entity.Tag;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {

    PageInfo<Product> findAll(Integer page, Integer rows);

    void add(Product product, String tagid);

    void remove(String id);

    void modify(Product product);

    Product findOne(String id);

    void removeAll(List<String> ids);

    List<Tag> findTag(String id);

    void addTag(String proid,String tagid);

    void delTag(String proid,String tagid);

    List<Product> All();

    List<Product> findProductByName(String keywords);
}
