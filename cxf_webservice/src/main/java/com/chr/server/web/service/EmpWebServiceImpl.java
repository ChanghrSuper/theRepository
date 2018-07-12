package com.chr.server.web.service;

import com.chr.server.entity.Emp;
import com.chr.server.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;
import java.util.UUID;


@WebService
public class EmpWebServiceImpl implements EmpWebService{

    @Autowired
    private EmpService empService;

    @Override
    public void insertEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empService.insertEmp(emp);
    }

    @Override
    public void deleteEmp(String id) {
        empService.deleteEmp(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        empService.updateEmp(emp);
    }

    @Override
    public List<Emp> selectAll() {
        return empService.selectAll();
    }

    @Override
    public Emp selectOne(String id) {
        return empService.selectOne(id);
    }
}
