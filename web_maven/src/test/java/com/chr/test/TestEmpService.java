package com.chr.test;

import com.chr.entity.Emp;
import com.chr.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-base.xml")
public class TestEmpService {

    @Autowired
    private EmpService empService;

    @Test
    public void findAll(){
        List<Emp> list = empService.findAll();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}
