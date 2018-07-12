package com.chr.test;

import com.chr.Application;
import com.chr.dao.AdminMapper;
import com.chr.entity.Admin;
import com.chr.entity.AdminExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMapper {

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void testAdmin(){
        AdminExample adminExample = new AdminExample();
        //adminExample.createCriteria().andUsernameEqualTo("aaa");
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        for (Admin admin : admins) {
            System.out.println(admin.getId()+"\n"+admin.getUsername()+"\n"+admin.getPassword()+"\n"+admin.getLever());
        }
    }

}
