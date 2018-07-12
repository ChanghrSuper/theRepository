package com.chr.dao;

import com.chr.entity.Emp;

import java.util.List;

public interface EmpDao {

	void insertEmp(Emp emp);
	
	void deleteEmp(String id);
	
	void updateEmp(Emp emp);
	
	List<Emp> selectAll();
	
	Emp selectOne(String id);
}
