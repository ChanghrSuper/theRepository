package test;

import com.chr.client.code2.Emp;
import com.chr.client.code2.EmpWebService;
import com.chr.server.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-basic.xml");
        EmpWebService empService = (EmpWebService) context.getBean("empPortType");
        List<Emp> emps = empService.selectAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }

    }

    @Test
    public void serviceSelAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-basic.xml");
        EmpService empService = (EmpService) context.getBean("empService");
        List<com.chr.server.entity.Emp> emps = empService.selectAll();
        for (com.chr.server.entity.Emp emp : emps) {
            System.out.println(emp);
        }
    }

}
