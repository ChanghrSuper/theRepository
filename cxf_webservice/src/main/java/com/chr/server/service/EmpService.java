package com.chr.server.service;

import com.chr.server.entity.Emp;

import java.util.List;


public interface EmpService {

    void insertEmp(Emp emp);

    void deleteEmp(String id);

    void updateEmp(Emp emp);

    List<Emp> selectAll();

    Emp selectOne(String id);
}
