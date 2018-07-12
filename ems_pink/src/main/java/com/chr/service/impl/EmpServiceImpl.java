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

@Service
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
    public void midify(Emp emp) {
        empDao.update(emp);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> findAll(String did,Integer page) {
        Integer size = 3;
        Integer begin = (page-1)*size;
        return empDao.selectAll(did,begin,size);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Emp findOne(String id) {
        return empDao.selectOne(id);
    }

    @Override
    public Integer maxPage(String did) {
        return empDao.countNum(did)%3==0?empDao.countNum(did)/3:empDao.countNum(did)/3+1;
    }
}
