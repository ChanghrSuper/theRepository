package com.chr.service.impl;

import com.chr.dao.BannerMapper;
import com.chr.entity.Banner;
import com.chr.entity.BannerExample;
import com.chr.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Banner> findAll() {
        BannerExample bannerExample = new BannerExample();
        List<Banner> banners = bannerMapper.selectByExample(bannerExample);
        return banners;
    }

    @Override
    public void remove(String id) {
        bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(String id,String path) {
        Banner banner = new Banner();
        banner.setId(id);
        banner.setCreatedate(new Date());
        banner.setPath(path);
        banner.setStatus("关闭");
        bannerMapper.insert(banner);
    }

    @Override
    public void modify(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public void removeAll(List<String> ids) {
        BannerExample example = new BannerExample();
        example.createCriteria().andIdIn(ids);
        bannerMapper.deleteByExample(example);
    }

    @Override
    public Banner findOne(String id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(String id) {
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        if(banner.getStatus().equals("关闭")) {
            banner.setStatus("开启");
        }else{
            banner.setStatus("关闭");
        }

        bannerMapper.updateByPrimaryKey(banner);
    }
}
