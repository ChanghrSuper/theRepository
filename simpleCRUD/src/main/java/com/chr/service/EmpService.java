package com.chr.service;

import com.chr.entity.Emp;

import java.util.List;

public interface EmpService {

    void save(Emp emp);

    void remove(String id);

    void modify(Emp emp);

    List<Emp> findAll();

    Emp findOne(String id);
}
