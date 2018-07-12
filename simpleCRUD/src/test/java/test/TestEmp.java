package test;

import com.chr.entity.Emp;
import com.chr.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestEmp {

    @Autowired
    private EmpService empService;

    @Test
    public void queryAll(){
        List<Emp> all = empService.findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }
    }

}
