package com.chr.dao;

import com.chr.entity.Photo;
import com.chr.entity.PhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoMapper {
    long countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}