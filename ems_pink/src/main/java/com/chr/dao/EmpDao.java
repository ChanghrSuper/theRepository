package com.chr.dao;

import com.chr.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    void insert(Emp emp);
    void delete(String id);
    void deleteDept(String did);
    void update(Emp emp);
    List<Emp> selectAll(@Param("did")String did, @Param("begin")Integer begin, @Param("size")Integer size);
    Emp selectOne(String id);
    Integer countNum(String did);
}
