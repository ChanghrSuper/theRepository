package com.chr.dao;

import com.chr.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAll();
}
