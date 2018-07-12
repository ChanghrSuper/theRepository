package com.chr.service.impl;

import com.chr.dao.AdminMapper;
import com.chr.entity.Admin;
import com.chr.entity.AdminExample;
import com.chr.service.AdminService;
import com.chr.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin findByUsernamePassword(Admin admin) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size()==0) {
            throw new RuntimeException("用户名错误~~~");
        }
        for (Admin dbAdmin : admins) {
            if (!dbAdmin.getPassword().equals(MD5Util.getMD5Code(admin.getPassword()+ dbAdmin.getSalt()))) {
                throw new RuntimeException("密码错误~~~");
            }
            return dbAdmin;
        }
        return null;
    }

    @Override
    public void addAdmin(Admin admin) {
        isUsernameExist(admin.getUsername());
        admin.setId(UUID.randomUUID().toString());
        admin.setLever("1");
        String salt = MD5Util.getSalt(5);
        admin.setSalt(salt);
        admin.setPassword(MD5Util.getMD5Code(admin.getPassword()+salt));
        adminMapper.insert(admin);
    }

    @Override
    public Boolean isUsernameExist(String username) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size()!=0)
            throw new RuntimeException("用户名已存在~~~");
        return false;
    }
}
