package com.chr.controller;

import com.chr.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/jackson")
public class JacksonController {

    @RequestMapping("/m")
    public ModelAndView m(ModelAndView modelAndView){
        modelAndView.addObject("emp","emp");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("j")
    public @ResponseBody Emp j(){
        return new Emp("1","huxz",12.0,12,new Date());
    }
}
