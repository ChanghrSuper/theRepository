package com.chr.server.service;

import com.chr.server.dao.EmpDao;
import com.chr.server.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public void insertEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.insertEmp(emp);
    }

    @Override
    public void deleteEmp(String id) {
        empDao.deleteEmp(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateEmp(emp);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> selectAll() {
        return empDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Emp selectOne(String id) {
        return empDao.selectOne(id);
    }
}
