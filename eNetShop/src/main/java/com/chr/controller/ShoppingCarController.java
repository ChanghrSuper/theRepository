package com.chr.controller;

import com.chr.entity.Result;
import com.chr.entity.Shoppingcar;
import com.chr.entity.User;
import com.chr.service.ShoppingCarService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCarController {

    @Resource
    private ShoppingCarService shoppingCarService;

    private Result result = new Result();

    @RequestMapping("/save")
    public Result save(Shoppingcar shoppingcar, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        shoppingCarService.add(user.getId(),shoppingcar);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/queryAll")
    public List<Shoppingcar> queryAll(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return shoppingCarService.findAll(user.getId());
    }

    @RequestMapping("/changeNum")
    public Result changeNum(String proid, Integer num, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(proid+"  "+num);
        shoppingCarService.changeNum(proid,num,user.getId());
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/cancel")
    public Result cancel(String proid, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        shoppingCarService.remove(user.getId(), proid);
        result.setStatus(true);
        return result;
    }
}
