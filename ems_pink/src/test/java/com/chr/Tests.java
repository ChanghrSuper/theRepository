package com.chr;

import com.chr.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Tests {

    @Autowired
    private EmpService empService;

    @Test
    public void test(){
        Integer maxPage = empService.maxPage("d3a00c3e-4525-4a4a-b497-5527886b603f");
        System.out.println(maxPage);

    }
}
