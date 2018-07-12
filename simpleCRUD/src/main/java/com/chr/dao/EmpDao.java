package com.chr.dao;

import com.chr.entity.Emp;

import java.util.List;

public interface EmpDao {

    void insert(Emp emp);

    void delete(String id);

    void update(Emp emp);

    List<Emp> selectAll();

    Emp selectOne(String id);
}
