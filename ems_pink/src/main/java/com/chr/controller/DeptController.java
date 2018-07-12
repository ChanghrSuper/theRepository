package com.chr.controller;

import com.chr.entity.Dept;
import com.chr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/queryAll")
    public String queryAll(HttpServletRequest request){
        List<Dept> depts = deptService.findAll();
        request.getSession().setAttribute("depts",depts);
        return "dept/deptlist";
    }

    @RequestMapping("/add")
    public String add(Dept dept){
        deptService.save(dept);
        return "redirect:/dept/queryAll";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        deptService.remove(id);
        return "redirect:/dept/queryAll";
    }

    @RequestMapping("/queryOne")
    public String queryOne(String id,HttpServletRequest request){
        Dept dept = deptService.findOne(id);
        request.setAttribute("dept",dept);
        return "dept/updateDept";
    }

    @RequestMapping("/update")
    public String update(Dept dept){
        deptService.moidfy(dept);
        return "redirect:/dept/queryAll";
    }
}
