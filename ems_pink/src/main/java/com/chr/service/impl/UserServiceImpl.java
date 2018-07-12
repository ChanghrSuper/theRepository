package com.chr.service.impl;

import com.chr.dao.UserDao;
import com.chr.entity.User;
import com.chr.service.UserService;
import com.chr.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        String salt = MD5Util.getSalt(5);
        user.setSalt(salt);
        user.setPassword(MD5Util.getMD5Code(user.getPassword()+salt));
        userDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findByUsernamePassword(User user) {
        User dbuser = userDao.selectByUsername(user.getUsername());
        if(dbuser==null){
            throw new RuntimeException("用户名错误~~~");
        }
        if(!dbuser.getPassword().equals(MD5Util.getMD5Code(user.getPassword()+dbuser.getSalt()))){
            throw new RuntimeException("密码错误~~~");
        }
        return dbuser;
    }
}
