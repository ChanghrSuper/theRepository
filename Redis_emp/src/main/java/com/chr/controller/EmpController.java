package com.chr.controller;

import com.chr.entity.Emp;
import com.chr.entity.Result;
import com.chr.service.EmpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Resource
    private EmpService empService;

    @RequestMapping("/queryAll")
    public Result queryAll(Integer page,Integer rows,String columName,String columValue){
        if(columName!=null && columValue!=null){
            System.out.println("搜索的请求。。。");
        }
        Result result = new Result();
        System.out.println(page+"---"+rows);
        result.setTotal(100);
        result.setRows(empService.findAll());
        return result;
    }

    @RequestMapping("/add")
    public String add(Emp emp){
        empService.addEmp(emp);
        return "ok";
    }

    @RequestMapping("/queryOne")
    public Emp queryOne(String id,HttpServletRequest request){
        return empService.findOne(id);
    }

    @RequestMapping("/update")
    public String update(Emp emp){
        empService.modifyEmp(emp);
        return "ok";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        empService.removeEmp(id);
        return "ok";
    }

    @RequestMapping("/deleteAll")
    public String deleteAll(String[] id){
        for (String s : id) {
            System.out.println(s);
        }
        return "ok";
    }
}
