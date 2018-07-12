package com.chr.service.impl;

import com.chr.dao.ProductMapper;
import com.chr.entity.Shoppingcar;
import com.chr.service.ShoppingCarService;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ProductMapper productMapper;

    @Override
    public void add(String userid, Shoppingcar shoppingcar) {
        shoppingcar.setUserid(userid);
        shoppingcar.setCreatedate(new Date());
        BoundHashOperations hashOperations = redisTemplate.boundHashOps(userid);
        Shoppingcar sc = (Shoppingcar) hashOperations.get(shoppingcar.getProid());
        if(sc==null) {
            shoppingcar.setProduct(productMapper.selectByPrimaryKey(shoppingcar.getProid()));
            hashOperations.put(shoppingcar.getProid(), shoppingcar);
        }else {
            sc.setProduct(productMapper.selectByPrimaryKey(sc.getProid()));
            sc.setNumber(sc.getNumber()+shoppingcar.getNumber());
            hashOperations.put(shoppingcar.getProid(), sc);
        }

    }


    @Override
    public List<Shoppingcar> findAll(String userid) {
        Map<String,Shoppingcar> entries = redisTemplate.opsForHash().entries(userid);
        List<Shoppingcar> shoppingcars = new ArrayList<>();
        for (Shoppingcar shoppingcar : entries.values()) {
            shoppingcars.add(shoppingcar);
        }
        return shoppingcars;
    }

    @Override
    public void changeNum(String proid, Integer num, String userid) {
        BoundHashOperations hashOperations = redisTemplate.boundHashOps(userid);
        Shoppingcar shoppingcar = (Shoppingcar) hashOperations.get(proid);
        shoppingcar.setNumber(shoppingcar.getNumber()+num);
        hashOperations.put(proid,shoppingcar);
    }

    @Override
    public void remove(String userid, String proid) {
        BoundHashOperations hashOperations = redisTemplate.boundHashOps(userid);
        hashOperations.delete(proid);
        if(hashOperations.size()==0){
            redisTemplate.delete(userid);
        }

    }
}
