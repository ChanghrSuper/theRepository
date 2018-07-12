package com.chr.controller;

import com.chr.entity.Emp;
import com.chr.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Resource
    private EmpService empService;

    @RequestMapping("/test1")
    public String test(){
        System.out.println("~~~~~~~~~");
        return "index";
    }

    @RequestMapping("/queryAll")
    public @ResponseBody List<Emp> queryAll(){
        return empService.findAll();
    }
}
