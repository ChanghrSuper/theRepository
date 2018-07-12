package com.chr.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class Beans {

    @Bean
    public Jedis getJedis(){
        return new Jedis("192.168.2.128", 6379);
    }
}
