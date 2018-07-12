package com.chr.controller;

import com.chr.entity.User;
import com.chr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request, HttpServletResponse response){
        System.out.println(user);
        try {
            User u = userService.findByUsernamePassword(user);
            request.getSession().setAttribute("user", u);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "redirect:/user/login.jsp";
        }
        return "redirect:/dept/queryAll";
    }

    @RequestMapping("/regist")
    public String regist(User user,String number,HttpServletRequest request){
        String code = (String)request.getSession().getAttribute("securityCode");
        if(code.equals(number)) {
            userService.save(user);
            return "redirect:/user/login.jsp";
        }
        return "redirect:/user/regist.jsp";
    }
}
