package com.chr.service.impl;

import com.chr.dao.EmpDao;
import com.chr.entity.Emp;
import com.chr.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpDao empDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> findAll() {
        return empDao.selectAll();
    }
}
