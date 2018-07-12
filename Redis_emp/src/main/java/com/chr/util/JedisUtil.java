package com.chr.util;

import com.alibaba.fastjson.JSONObject;
import com.chr.entity.Emp;
import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisUtil {

    public static Jedis getJedis(Integer db){
        Jedis jedis = new Jedis("192.168.2.128",6379);//创建Jedis对象
        jedis.select(db);
        return jedis;
    }

    public static void updateList(String listName,List<Emp> emps,Integer db){
        Jedis jedis = getJedis(db);
        for (Emp emp : emps) {
            String json = JSONObject.toJSONStringWithDateFormat(emp, "yyyy-MM-dd");
            jedis.set(emp.getId(),json);
            jedis.rpush(listName,emp.getId());
        }
    }
}
