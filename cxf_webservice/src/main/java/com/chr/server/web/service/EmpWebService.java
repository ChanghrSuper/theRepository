package com.chr.server.web.service;

import com.chr.server.entity.Emp;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface EmpWebService {

    void insertEmp(Emp emp);

    void deleteEmp(String id);

    void updateEmp(Emp emp);

    List<Emp> selectAll();

    Emp selectOne(String id);
}
