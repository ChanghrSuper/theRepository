package com.chr.aspect;

import com.alibaba.fastjson.JSONObject;
import com.chr.annotations.RedisCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@Configuration
@Aspect
public class RedisCacheAspect {

    @Resource
    private Jedis jedis;//从工厂中获取Jedis对象

    //开发环绕通知
    //execution 方法级别表达式  within 类级别表达式  @annotation类型切入点
    @Around("@annotation(com.chr.annotations.RedisCache)")
    public Object around(ProceedingJoinPoint pjp){
        RedisCache annotation = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(RedisCache.class);
        System.out.println("切入"+annotation.value());
        //获取key
        String hashKey = getHashKey(pjp);
        String HashValueKey = getHashValueKey(pjp);
        Object result = null;
        //判断redis中是否存在这个key
        if(jedis.hexists(hashKey,HashValueKey)){//存在获取后返回
            System.out.println("redis中存在，直接获取响应");
            String json = jedis.hget(hashKey,HashValueKey);
            //集合类型json 转为list集合 [{}]List<User.class>   对象类型json  直接转为对象{}  User.class
            MethodSignature signature = (MethodSignature)pjp.getSignature();
            System.out.println("带泛型的返回值类型"+signature.getMethod().getGenericReturnType());
            result = JSONObject.parseObject(json,signature.getMethod().getGenericReturnType());
        }else {//放行Dao方法执行存入redis中
            System.out.println("redis中不存在，查询数据库");
            try {
                result = pjp.proceed();
                //放入redis  以接送形式存入
                jedis.hset(hashKey,HashValueKey,JSONObject.toJSONString(result));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return result;
    }

    //生成hashkey方法
    public String getHashKey(ProceedingJoinPoint pjp){
        //类名
        String clazzName = pjp.getTarget().getClass().getClass().getName();
        //类名生成MD5
        return DigestUtils.md5DigestAsHex(clazzName.getBytes());
    }

    //hash 中的value的key
    public String  getHashValueKey(ProceedingJoinPoint pjp){
        //生成key
        StringBuilder builder = new StringBuilder();
        //方法名
        String methodName = pjp.getSignature().getName();
        builder.append(methodName);
        //参数
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            builder.append(arg);
        }
        return DigestUtils.md5DigestAsHex(builder.toString().getBytes());
    }

    /**
     * 用来维护增删改查的缓存
     */
    @After("execution(* com.chr.service.impl.*ServiceImpl.*(..)) && !@annotation(com.chr.annotations.RedisCache)")
    public void after(JoinPoint joinPoint){
        //获取类名
        String keyPrefix = DigestUtils.md5DigestAsHex(joinPoint.getTarget().getClass().getName().getBytes());
        System.out.println("增删改维护---"+keyPrefix);
        //删除
        jedis.del(keyPrefix);
    }



}
