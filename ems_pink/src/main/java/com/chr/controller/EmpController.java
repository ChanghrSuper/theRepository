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
    public String queryAll(String did, Integer page, HttpServletRequest request){
        page = page==null?1:page;
        List<Emp> emps = empService.findAll(did,page);
        Integer maxPage = empService.maxPage(did);
        request.setAttribute("emps",emps);
        request.setAttribute("maxPage",maxPage);
        return "emp/emplist";
    }

    @RequestMapping("/add")
    public String add(Emp emp,String did){
        empService.save(emp);
        return "redirect:/emp/queryAll?did="+did;
    }

    @RequestMapping("/delete")
    public String delete(String id,String did){
        empService.remove(id);
        return "redirect:/emp/queryAll?did="+did;
    }

    @RequestMapping("/queryOne")
    public String queryOne(String id,String did,HttpServletRequest request){
        Emp emp = empService.findOne(id);
        request.setAttribute("emp",emp);
        return "emp/updateEmp";
    }

    @RequestMapping("/update")
    public String update(Emp emp,String did){
        empService.midify(emp);
        return "redirect:/emp/queryAll?did="+did;
    }
}
