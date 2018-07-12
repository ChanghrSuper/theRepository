package com.chr;

import com.chr.dao.ProductsDao;
import com.chr.entity.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestProductsDao {

    @Resource
    private ProductsDao productsDao;

    @Test
    public void insert(){
        productsDao.insert(new Products("2","香蕉",3.0,"好吃~","不知","XIANGJIAO"));
    }

    @Test
    public void delete(){
        productsDao.delete("1");
    }

    @Test
    public void update(){
        productsDao.update(new Products("1","苹果",2.0,"好吃~","不知","PINGGUO"));
    }

    @Test
    public void select(){
        List<Products> list = productsDao.select("苹");
        for (Products products : list) {
            System.out.println(products);
        }
    }

    @Test
    public void selectOne(){
        Products products = productsDao.selectOne("1");
        System.out.println(products);
    }
}
