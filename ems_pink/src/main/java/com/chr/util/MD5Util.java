package com.chr.util;

import org.springframework.util.DigestUtils;

import java.util.Random;

/**
 * MD5(spring)工具类
 *      使用了spring的jar包
 */
public class MD5Util {

    public static String getMD5Code(String string){
        return DigestUtils.md5DigestAsHex(string.getBytes());
    }

    /**
     *
     * @param n 生成的盐的位数
     * @return 返回盐字符串
     */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<n;i++){
            builder.append(chars[new Random().nextInt(chars.length)]);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println(getSalt(5));
        System.out.println((getMD5Code("123456")+getSalt(5)).length());
    }
}
