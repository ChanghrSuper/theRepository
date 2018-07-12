package com.chr.dao;

import com.chr.entity.Tag_Product;
import com.chr.entity.Tag_ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Tag_ProductMapper {
    long countByExample(Tag_ProductExample example);

    int deleteByExample(Tag_ProductExample example);

    int insert(Tag_Product record);

    int insertSelective(Tag_Product record);

    List<Tag_Product> selectByExample(Tag_ProductExample example);

    int updateByExampleSelective(@Param("record") Tag_Product record, @Param("example") Tag_ProductExample example);

    int updateByExample(@Param("record") Tag_Product record, @Param("example") Tag_ProductExample example);
}