package com.chr.test;

import com.alibaba.fastjson.JSONObject;
import com.chr.Application;
import com.chr.dao.EmpDao;
import com.chr.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestRedis {

    @Resource
    private EmpDao empDao;

    @Test
    public void testSetAll(){
        Jedis jedis = new Jedis("192.168.2.128",6379);
        jedis.select(0);
        List<Emp> emps = empDao.selectAll();
        for (Emp emp : emps) {
            String json = JSONObject.toJSONStringWithDateFormat(emp, "yyyy-MM-dd");
            jedis.hset("ALL",emp.getId(),json);
        }
        System.out.println(emps);
        System.out.println("over~");
    }

    @Test
    public void testGetAll(){
        Jedis jedis = new Jedis("192.168.2.128",6379);
        jedis.select(0);
        Map<String, String> map = jedis.hgetAll("ALL");
        System.out.println(map);
        List<Emp> emps = new ArrayList<>();
        System.out.println(map.values().size());
        /*for (String json : map.values()) {
            System.out.println(json);
            Emp emp = JSONObject.parseObject(json, Emp.class);
            emps.add(emp);
        }*/
        /*for (Map.Entry<String, String> entry : map.entrySet()) {
            String json = entry.getValue();
            System.out.println(json);
            Emp emp = JSONObject.parseObject(json, Emp.class);
            emps.add(emp);
        }*/
        for (String s : map.keySet()) {
            String json = map.get(s);System.out.println(json);
            Emp emp = JSONObject.parseObject(json, Emp.class);
            emps.add(emp);
        }
        System.out.println(emps);
    }

    @Test
    public void testTTT(){
        Emp emp = empDao.selectOne("155c2ffd-3bc3-4ea7-a3ae-cfc4a2aaf9ff");
        String json = JSONObject.toJSONStringWithDateFormat(emp, "yyyy-MM-dd");
        Emp e = JSONObject.parseObject(json, Emp.class);
        System.out.println(emp);
        System.out.println(json);
        System.out.println(e);
    }

    @Test
    public void TestGetString(){
        Jedis jedis = new Jedis("192.168.2.128",6379);
        jedis.select(0);
        String name = jedis.get("name");
        System.out.println(name);
    }
}
