package com.chr.dao;

import com.chr.entity.Dept;

import java.util.List;

public interface DeptDao {
    void insert(Dept dept);
    void delete(String id);
    void update(Dept dept);
    List<Dept> selectAll();
    Dept selectOne(String id);
}
