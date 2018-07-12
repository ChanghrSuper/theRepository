package com.chr.client.controller;


import com.chr.client.code.Emp;
import com.chr.client.code.EmpWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpWebService empWebService;

    @RequestMapping("/queryAll")
    public String queryAll(HttpServletRequest request){
        List<Emp> emps = empWebService.findAll();
        request.setAttribute("emps",emps);
        return "ems/emplist";
    }

    @RequestMapping("/add")
    public String add(Emp emp){
        empWebService.save(emp);
        return "redirect:/emp/queryAll";
    }

    @RequestMapping("/queryOne")
    public String queryOne(String id,HttpServletRequest request){
        Emp emp = empWebService.findOne(id);
        request.setAttribute("emp",emp);
        return "ems/updateEmp";
    }

    @RequestMapping("/update")
    public String update(Emp emp){
        empWebService.update(emp);
        return "redirect:/emp/queryAll";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        empWebService.delete(id);
        return "redirect:/emp/queryAll";
    }
}
