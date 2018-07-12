package com.chr.controller;

import com.chr.entity.Products;
import com.chr.service.ProductsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @RequestMapping("/add")
    public String add(Products products){
        System.out.println(products);
        productsService.save(products);
        return "ok";
    }

    @RequestMapping("/cancel")
    public String cancel(String id){
        productsService.remove(id);
        return "ok";
    }

    @RequestMapping("/alter")
    public String alter(Products products){
        productsService.modify(products);
        return "ok";
    }

    @RequestMapping("/query")
    public List<Products> query(String name){
        return productsService.find(name);
    }

    @RequestMapping("/queryOne")
    public Products queryOne(String id){
        return productsService.findOne(id);
    }
}
