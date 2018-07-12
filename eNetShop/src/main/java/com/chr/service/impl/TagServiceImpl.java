package com.chr.service.impl;

import com.chr.dao.TagMapper;
import com.chr.entity.Tag;
import com.chr.entity.TagExample;
import com.chr.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> findByLevel(Integer level) {
        TagExample example = new TagExample();
        example.createCriteria().andLeverEqualTo(level);
        return tagMapper.selectByExample(example);
    }

    @Override
    public void remove(String id) {
        /*Tag tag = tagMapper.selectByPrimaryKey(id);
        Integer lever = tag.getLever();

        TagExample example = new TagExample();
        example.createCriteria().andParentidEqualTo(id);
        List<Tag> tags = tagMapper.selectByExample(example);
        for (Tag t : tags) {
            example.createCriteria().andParentidEqualTo(t.getId());
            List<Tag> tags1 = tagMapper.selectByExample(example);
        }*/

        tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void modify(Tag tag) {
        tagMapper.updateByPrimaryKeySelective(tag);
    }

    @Override
    public void add(Tag tag) {
        tag.setId(UUID.randomUUID().toString());
        tagMapper.insert(tag);
    }

    @Override
    public Tag findOne(String id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tag> findByParentId(String parentid) {
        TagExample example = new TagExample();
        example.createCriteria().andParentidEqualTo(parentid);
        return tagMapper.selectByExample(example);
    }

    @Override
    public void removeAll(List<String> ids) {
        TagExample example = new TagExample();
        example.createCriteria().andIdIn(ids);
        tagMapper.deleteByExample(example);
    }
}
