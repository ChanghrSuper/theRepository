package com.chr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用来测试redirect跳转以及forward跳转
 */

@Controller
@RequestMapping("/redirectandforward")
public class RedirectAndForward {

    //forward从controller跳转到controller
    @RequestMapping("test1")
    public String test1(){
        System.out.println("forward---controller");
        return "forward:/hello/hello";
    }

    //redirect从controller跳转到jsp
    @RequestMapping("test2")
    public String test2(){
        System.out.println("dedirect===jsp");
        return "redirect:/index.jsp";
    }

    //redirect从controller跳转到controller
    @RequestMapping("test3")
    public String test3(){
        System.out.println("direct***controller");
        return "redirect:/hello/hello";
    }
}
