package com.chr.service.impl;

import com.chr.dao.OrdersMapper;
import com.chr.entity.Orders;
import com.chr.entity.Shoppingcar;
import com.chr.service.OrderService;
import com.chr.util.SnowFlake;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void addOrderFromProduct(String userid, Orders orders) {

    }

    @Override
    public void addOrderFromShoppingCar(String userid, String[] proids) {
        BoundHashOperations hashOperations = redisTemplate.boundHashOps(userid);
        List<Orders> orders = new ArrayList<>();
        for (String proid : proids) {
            Shoppingcar shoppingcar = (Shoppingcar) hashOperations.get(proid);
            String snowid = SnowFlake.getId();
            Orders o = new Orders();
            o.setSnowid(snowid);
            o.setUserid(userid);

        }
    }
}
