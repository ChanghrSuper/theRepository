package com.chr.service;

import com.chr.entity.Dept;

import java.util.List;

public interface DeptService {

    void save(Dept dept);
    void remove(String id);
    void moidfy(Dept dept);
    List<Dept> findAll();
    Dept findOne(String id);
}
