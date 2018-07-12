package com.chr.service.impl;

import com.chr.dao.ProductsDao;
import com.chr.entity.Products;
import com.chr.service.ProductsService;
import com.chr.util.PinyinUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {

    @Resource
    private ProductsDao productsDao;

    @Override
    public void save(Products products) {
        products.setId(UUID.randomUUID().toString());
        products.setPinyin(PinyinUtils.getHanyupinyin(products.getName()));
        productsDao.insert(products);
    }

    @Override
    public void remove(String id) {
        productsDao.delete(id);
    }

    @Override
    public void modify(Products products) {
        productsDao.update(products);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Products> find(String name) {
        return productsDao.select(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Products findOne(String id) {
        return productsDao.selectOne(id);
    }
}
