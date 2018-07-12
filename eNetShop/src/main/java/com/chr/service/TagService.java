package com.chr.service;

import com.chr.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findByLevel(Integer level);

    void remove(String id);

    void modify(Tag tag);

    void add(Tag tag);

    Tag findOne(String id);

    List<Tag> findByParentId(String parentid);

    void removeAll(List<String> ids);

}
