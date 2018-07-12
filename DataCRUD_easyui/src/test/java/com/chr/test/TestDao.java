package com.chr.test;

import com.chr.Application;
import com.chr.dao.EmpDao;
import com.chr.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestDao {

    @Resource
    private EmpDao empDao;

    @Test
    public void test(){
        List<Emp> emps = empDao.selectAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
}
