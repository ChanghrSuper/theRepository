package com.chr.service.impl;

import com.chr.dao.DeptDao;
import com.chr.dao.EmpDao;
import com.chr.entity.Dept;
import com.chr.service.DeptService;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private EmpDao empDao;

    @Override
    public void save(Dept dept) {
        dept.setId(UUID.randomUUID().toString());
        deptDao.insert(dept);
    }

    @Override
    public void remove(String id) {
        empDao.deleteDept(id);
        deptDao.delete(id);
    }

    @Override
    public void moidfy(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Dept> findAll() {
        return deptDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Dept findOne(String id) {
        return deptDao.selectOne(id);
    }
}
