package com.chr.service.impl;

import com.chr.dao.EmpDao;
import com.chr.entity.Emp;
import com.chr.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

    @Resource
    private EmpDao empDao;


    @Override
    public void addEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.insertEmp(emp);
    }

    @Override
    public void removeEmp(String id) {
        empDao.deleteEmp(id);
    }

    @Override
    public void modifyEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> findAll() {
        return empDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Emp findOne(String id) {
        return empDao.selectOne(id);
    }
}
