package com.chr.test;

import com.chr.dao.MasterSlaveDao;
import com.chr.entity.MasterSlave;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-base.xml")
public class TestMasterSlaveDao {
    @Autowired
    private MasterSlaveDao masterSlaveDao;

    @Test
    public void testInsert(){
        masterSlaveDao.insert(new MasterSlave("0","aaaaa"));
    }

    @Test
    public void testSelectAll(){
        for(int i=0;i<100;i++) {
            List<MasterSlave> masterSlaves = masterSlaveDao.selectAll();
            for (MasterSlave masterSlave : masterSlaves) {
                System.out.println(masterSlave);
            }
        }
    }
}
