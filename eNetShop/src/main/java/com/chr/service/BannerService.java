package com.chr.service;

import com.chr.entity.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface BannerService {

    List<Banner> findAll();

    void remove(String id);

    void add(String id,String path);

    void modify(Banner banner);

    void removeAll(List<String> ids);

    Banner findOne(String id);

    void update(String id);

}
