package com.chr.controller;

import com.alibaba.fastjson.JSONObject;
import com.chr.entity.Result;
import com.chr.entity.User;
import com.chr.service.UserService;
import com.chr.util.SecurityCode;
import com.chr.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request,HttpServletResponse response) throws IOException {
        Result result = new Result();
        response.setContentType("text/plain;charset=utf-8");
        try {
            User u = userService.findByUsernameAndPassword(user);
            request.getSession().setAttribute("user", u);
            result.setStauts(true);
        }catch (Exception e){
            result.setMessage(e.getMessage());
        }
        String jsonString = JSONObject.toJSONString(result);
        response.getWriter().print(jsonString);
        return null;
    }

    @RequestMapping("/regist")
    public String regist(User user,String number,HttpServletRequest request){
        String securityCode = (String)request.getSession().getAttribute("securityCode");
        if(!securityCode.equalsIgnoreCase(number)){
            return "/ems/regist.jsp";
        }
        System.out.println(user+"-----");
        userService.addUser(user);
        return "redirect:/ems/login.jsp";
    }

    @RequestMapping("/Captcha")
    public String Captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //设置响应类型
        response.setContentType("image/png");
        //获取验证码和图片
        String securityCode = SecurityCode.getSecurityCode();
        BufferedImage image = SecurityImage.createImage(securityCode);
        //使用值栈存入session
        request.getSession().setAttribute("securityCode", securityCode);

        ImageIO.write(image, "png", response.getOutputStream());

        return null;
    }

    @RequestMapping("/isExist")
    public @ResponseBody Boolean isExist(String name) {
        return userService.findUsername(name);
    }


}
