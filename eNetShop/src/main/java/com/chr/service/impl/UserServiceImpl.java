package com.chr.service.impl;

import com.chr.dao.AddressMapper;
import com.chr.dao.UserMapper;
import com.chr.entity.*;
import com.chr.service.UserService;
import com.chr.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private AddressMapper addressMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findAll() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findOne(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(User user) {
        String salt = MD5Util.getSalt(5);
        user.setSalt(salt);
        user.setId(UUID.randomUUID().toString());
        user.setPassword(MD5Util.getMD5Code(user.getPassword()+salt));
        user.setStatus("普通用户");
        userMapper.insertSelective(user);
    }

    @Override
    public void remove(String id) {
        User u = userMapper.selectByPrimaryKey(id);
        if (u.getStatus().equals("冻结")) {
            userMapper.deleteByPrimaryKey(id);
            AddressExample example = new AddressExample();
            example.createCriteria().andUseridEqualTo(id);
            addressMapper.deleteByExample(example);
        }else{
            User user = new User();
            user.setId(id);
            user.setStatus("冻结");
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public void modify(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<Address> findAddr(String userid) {
        AddressExample example = new AddressExample();
        example.createCriteria().andUseridEqualTo(userid);
        return addressMapper.selectByExample(example);
    }

    @Override
    public void addAddr(Address addr) {
        addr.setId(UUID.randomUUID().toString());
        addressMapper.insert(addr);
    }

    @Override
    public void delAddr(String id) {
        addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findByUsernamePassword(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhonenumberEqualTo(user.getPhonenumber());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()==0) {
            throw new RuntimeException("用户名错误~~~");
        }
        for (User dbUser : users) {
            if (!dbUser.getPassword().equals(MD5Util.getMD5Code(user.getPassword()+ dbUser.getSalt()))) {
                throw new RuntimeException("密码错误~~~");
            }
            return dbUser;
        }
        return null;
    }
}
