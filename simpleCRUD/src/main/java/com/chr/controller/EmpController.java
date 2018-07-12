package com.chr.controller;

import com.chr.entity.Emp;
import com.chr.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/queryAll")
    public String queryAll(HttpServletRequest request){
        List<Emp> emps = empService.findAll();
        request.setAttribute("emps",emps);
        return "ems/emplist";
    }

    @RequestMapping("/add")
    public String add(Emp emp){
        empService.save(emp);
        return "redirect:/emp/queryAll";
    }

    @RequestMapping("/queryOne")
    public String queryOne(String id,HttpServletRequest request){
        Emp emp = empService.findOne(id);
        request.setAttribute("emp",emp);
        return "ems/updateEmp";
    }

    @RequestMapping("/update")
    public String update(Emp emp){
        empService.modify(emp);
        return "redirect:/emp/queryAll";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        empService.remove(id);
        return "redirect:/emp/queryAll";
    }
}
