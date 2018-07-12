package com.chr.service.impl;

import com.chr.dao.EmpDao;
import com.chr.entity.Emp;
import com.chr.service.EmpService;
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
    public void save(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.insert(emp);
    }

    @Override
    public void remove(String id) {
        empDao.delete(id);
    }

    @Override
    public void modify(Emp emp) {
        empDao.update(emp);
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
