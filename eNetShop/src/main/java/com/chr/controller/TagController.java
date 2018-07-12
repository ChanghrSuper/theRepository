package com.chr.controller;

import com.chr.entity.Result;
import com.chr.entity.Tag;
import com.chr.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    private Result result = new Result();

    @RequestMapping("/queryByLevel")
    public List<Tag> queryByLevel(Integer level){
        return tagService.findByLevel(level);
    }

    @RequestMapping("/cancel")
    public Result cancel(String id,HttpServletRequest request){
        Tag tag = tagService.findOne(id);
        if(tag.getLever()==4){
            String realPath = request.getSession().getServletContext().getRealPath(tag.getLogourl());
            File file = new File(realPath);
            file.delete();
        }
        tagService.remove(id);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/save")
    public Result save(Tag tag,MultipartFile file,HttpServletRequest request) throws IOException {
        if (file!=null) {
            //相对路径获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            String originalFilename = file.getOriginalFilename();//获取文件名
            System.out.println(originalFilename);
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString();
            String newName = uuid+"."+split[1];
            file.transferTo(new File(realPath,newName));
            tag.setLogourl("\\upload\\"+newName);
        }
        tagService.add(tag);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/alter")
    public Result alter(Tag tag){
        tagService.modify(tag);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/queryOne")
    public Tag queryOne(String id){
        return tagService.findOne(id);
    }

    @RequestMapping("/queryByPrtId")
    public List<Tag> queryByPrtId(String parentid){
        return tagService.findByParentId(parentid);
    }

    @RequestMapping("/cancelAll")
    public Result cancelAll(String[] ids,HttpServletRequest request){
        System.out.println("*******");
        List<String> strings = Arrays.asList(ids);
        for (String string : strings) {
            Tag tag = tagService.findOne(string);
            if (tag.getLever()==4) {
                String realPath = request.getSession().getServletContext().getRealPath(tag.getLogourl());
                File file = new File(realPath);
                file.delete();
            }
        }
        tagService.removeAll(strings);
        result.setStatus(true);
        result.setMessage("删除成功~~~");
        return result;
    }
}
