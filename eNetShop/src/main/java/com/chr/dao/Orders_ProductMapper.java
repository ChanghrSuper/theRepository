package com.chr.dao;

import com.chr.entity.Orders_Product;
import com.chr.entity.Orders_ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Orders_ProductMapper {
    long countByExample(Orders_ProductExample example);

    int deleteByExample(Orders_ProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orders_Product record);

    int insertSelective(Orders_Product record);

    List<Orders_Product> selectByExample(Orders_ProductExample example);

    Orders_Product selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Orders_Product record, @Param("example") Orders_ProductExample example);

    int updateByExample(@Param("record") Orders_Product record, @Param("example") Orders_ProductExample example);

    int updateByPrimaryKeySelective(Orders_Product record);

    int updateByPrimaryKey(Orders_Product record);
}