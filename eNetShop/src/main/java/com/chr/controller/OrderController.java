package com.chr.controller;

import com.chr.entity.Result;
import com.chr.entity.User;
import com.chr.service.OrderService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    private Result result = new Result();

    @RequestMapping("/settle")
    public Result settle(String[] ids, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        orderService.addOrderFromShoppingCar(user.getId(), ids);
        return result;
    }
}
