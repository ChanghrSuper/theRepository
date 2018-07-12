package com.chr.controller;

import com.chr.entity.Banner;
import com.chr.entity.Result;
import com.chr.service.BannerService;
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
@RequestMapping("/banner")
public class BannerController {

    @Resource
    private BannerService bannerService;

    private Result result = new Result();

    @RequestMapping("/upload")
    public Result save(MultipartFile file[], HttpServletRequest request) throws IOException {
        //相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(file.length+"个文件");
        for (MultipartFile f : file) {
            String originalFilename = f.getOriginalFilename();//获取文件名
            System.out.println(originalFilename);
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString();
            String newName = uuid+"."+split[1];
            f.transferTo(new File(realPath,newName));
            bannerService.add(uuid,"\\upload\\"+newName);
        }
        result.setMessage("true");
        return result;
    }

    @RequestMapping("/showAll")
    public List<Banner> showAll(){
        return bannerService.findAll();
    }

    @RequestMapping("/cancel")
    public Result cancel(String id,HttpServletRequest request){
        Banner banner = bannerService.findOne(id);
        String realPath = request.getSession().getServletContext().getRealPath(banner.getPath());
        File file = new File(realPath);
        file.delete();
        bannerService.remove(id);
        result.setMessage("true");
        return result;
    }

    @RequestMapping("/alter")
    public Result alter(Banner banner){
        bannerService.modify(banner);
        result.setStatus(true);
        result.setMessage("状态已更改");
        return result;
    }

    @RequestMapping("/cancelAll")
    public Result cancelAll(String[] ids,HttpServletRequest request){
        System.out.println("*******");
        List<String> strings = Arrays.asList(ids);
        for (String string : strings) {
            Banner banner = bannerService.findOne(string);
            String realPath = request.getSession().getServletContext().getRealPath(banner.getPath());
            File file = new File(realPath);
            file.delete();
        }
        bannerService.removeAll(strings);
        result.setStatus(true);
        result.setMessage("删除成功~~~");
        return result;
    }

    @RequestMapping("/changeStatus")
    public Result changeStatus(String id){
        bannerService.update(id);
        result.setStatus(true);
        result.setMessage("状态修改成功~~~");
        return result;
    }
}
