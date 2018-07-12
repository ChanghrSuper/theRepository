package com.chr.dao;

import com.chr.entity.Shoppingcar;
import com.chr.entity.ShoppingcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingcarMapper {
    long countByExample(ShoppingcarExample example);

    int deleteByExample(ShoppingcarExample example);

    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);

    List<Shoppingcar> selectByExample(ShoppingcarExample example);

    int updateByExampleSelective(@Param("record") Shoppingcar record, @Param("example") ShoppingcarExample example);

    int updateByExample(@Param("record") Shoppingcar record, @Param("example") ShoppingcarExample example);
}