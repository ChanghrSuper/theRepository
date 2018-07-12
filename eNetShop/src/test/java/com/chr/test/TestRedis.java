package com.chr.test;

import com.chr.Application;
import com.chr.entity.Shoppingcar;
import com.chr.service.ShoppingCarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ShoppingCarService shoppingCarService;

    @Test
    public void testredis(){
        redisTemplate.opsForValue().set("666","666121......");
        String s = (String)redisTemplate.opsForValue().get("666");
        System.out.println(s);
    }

    @Test
    public void findAll(){
        List<Shoppingcar> list = shoppingCarService.findAll("8a24a18f-dc97-4a09-87ee-e1d5f531ebec");
        for (Shoppingcar shoppingcar : list) {
            System.out.println(shoppingcar.getUserid());
            System.out.println(shoppingcar.getProid());
            System.out.println(shoppingcar.getNumber());
            System.out.println(shoppingcar.getCreatedate());
        }
    }
}
