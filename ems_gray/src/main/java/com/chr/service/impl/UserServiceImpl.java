package com.chr.service.impl;

import com.chr.dao.UserDao;
import com.chr.entity.User;
import com.chr.exceptions.UserErrorException;
import com.chr.service.UserService;
import com.chr.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findByUsernameAndPassword(User user) {
        User dbUser = userDao.selectByUsername(user.getUsername());
        System.out.println(dbUser+"----------");
        if(dbUser==null){
            throw new UserErrorException("用户名错误~~~");
        }
        if(!dbUser.getPassword().equals(MD5Util.getMD5Code(user.getPassword()+dbUser.getSalt()))){
            throw new UserErrorException("密码错误~~~");
        }
        return dbUser;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+"=====");
        user.setId(UUID.randomUUID().toString());
        String salt = MD5Util.getSalt(5);
        user.setSalt(salt);
        user.setPassword(MD5Util.getMD5Code(user.getPassword()+salt));
        userDao.insertUser(user);
    }

    @Override
    public Boolean findUsername(String name) {
        User user = userDao.selectByUsername(name);
        if(user==null) {
            return true;
        }else{
            return false;
        }
    }


}
