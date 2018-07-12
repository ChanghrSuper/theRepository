package com.chr.dao;

import com.chr.entity.MasterSlave;

import java.util.List;

public interface MasterSlaveDao {

    List<MasterSlave> selectAll();

    void insert(MasterSlave masterSlave);
}
