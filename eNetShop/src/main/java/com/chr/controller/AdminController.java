package com.chr.controller;

import com.alibaba.fastjson.JSONObject;
import com.chr.entity.Admin;
import com.chr.entity.Result;
import com.chr.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    private Result result = new Result();

    @RequestMapping("/login")
    public Result login(Admin admin, String code, HttpServletRequest request){
        String securityCode = (String)request.getSession().getAttribute("securityCode");
        if(code.equalsIgnoreCase(securityCode)) {
            try {
                Admin dbAdmin = adminService.findByUsernamePassword(admin);
                result.setStatus(true);
                result.setMessage(JSONObject.toJSONString(dbAdmin));
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                result.setStatus(false);
                result.setMessage(e.getMessage());
                return result;
            }
        }
        result.setStatus(false);
        result.setMessage("验证码错误~~~");
        return result;
    }

    @RequestMapping("/regist")
    public Result regist(Admin admin,String code, HttpServletRequest request){
        String securityCode = (String)request.getSession().getAttribute("securityCode");
        if(code.equalsIgnoreCase(securityCode)) {
            try {
                adminService.addAdmin(admin);
                result.setStatus(true);
                result.setMessage("注册成功~~~");
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                result.setStatus(false);
                result.setMessage(e.getMessage());//用户名重复处理
                return result;
            }
        }
        result.setStatus(false);
        result.setMessage("验证码错误~~~");
        return result;
    }

    @RequestMapping("/isExist")
    public Result isExist(String username){
        try {
            Boolean is = adminService.isUsernameExist(username);
            result.setStatus(true);
            result.setMessage("用户名合法~~~");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMessage(e.getMessage());//用户名重复处理
            return result;
        }
    }

}
