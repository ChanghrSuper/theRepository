package com.chr.dao;

import com.chr.entity.Tag;
import com.chr.entity.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(String id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}