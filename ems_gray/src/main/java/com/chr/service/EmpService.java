package com.chr.service;

import com.chr.entity.Emp;

import java.util.List;

public interface EmpService {

	void addEmp(Emp emp);
	
	void removeEmp(String id);
	
	void modifyEmp(Emp emp);
	
	List<Emp> findAll();
	
	Emp findOne(String id);
}
