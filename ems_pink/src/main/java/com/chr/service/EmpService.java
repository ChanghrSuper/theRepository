package com.chr.service;

import com.chr.entity.Emp;

import java.util.List;

public interface EmpService {

    void save(Emp emp);
    void remove(String id);
    void midify(Emp emp);
    List<Emp> findAll(String did,Integer page);
    Emp findOne(String id);
    Integer maxPage(String did);
}
