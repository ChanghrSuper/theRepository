package com.chr.controller;

import com.alibaba.fastjson.JSONObject;
import com.chr.entity.Address;
import com.chr.entity.Result;
import com.chr.entity.User;
import com.chr.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    private Result result = new Result();

    @RequestMapping("/queryAll")
    public List<User> queryAll(){
        return userService.findAll();
    }

    @RequestMapping("/queryOne")
    public User queryOne(String id){
        return userService.findOne(id);
    }

    @RequestMapping("/save")
    public Result save(User user, MultipartFile file, HttpServletRequest request) throws IOException {
        if (file != null && !file.isEmpty()) {
            //相对路径获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            String originalFilename = file.getOriginalFilename();//获取文件名
            System.out.println(originalFilename);
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString();
            String newName = uuid+"."+split[1];
            file.transferTo(new File(realPath,newName));
            user.setPhotopath("\\upload\\"+newName);
        }
        userService.add(user);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/cancel")
    public Result cancel(String id, HttpServletRequest request){
        User user = userService.findOne(id);
        String realPath = request.getSession().getServletContext().getRealPath(user.getPhotopath());
        File file = new File(realPath);
        file.delete();
        userService.remove(id);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/alter")
    public Result alter(User user, MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            //相对路径获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            String originalFilename = file.getOriginalFilename();//获取文件名
            System.out.println(originalFilename);
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString();
            String newName = uuid+"."+split[1];
            file.transferTo(new File(realPath,newName));
            String oldRealPath = request.getSession().getServletContext().getRealPath(user.getPhotopath());
            File oldfile = new File(oldRealPath);
            oldfile.delete();
            user.setPhotopath("\\upload\\"+newName);
        }
        userService.modify(user);
        result.setStatus(true);
        return result;

    }

    @RequestMapping("/queryAddr")
    public List<Address> queryAddr(String userid){
        return userService.findAddr(userid);
    }

    @RequestMapping("/saveAddr")
    public Result saveAddr(Address addr){
        userService.addAddr(addr);
        return result;
    }

    @RequestMapping("/delAddr")
    public Result delAddr(String id){
        userService.delAddr(id);
        return result;
    }

    @RequestMapping("/login")
    public Result login(User user, String code, HttpServletRequest request){
        String securityCode = (String)request.getSession().getAttribute("securityCode");
        if(code.equalsIgnoreCase(securityCode)) {
            try {
                User dbUser = userService.findByUsernamePassword(user);
                request.getSession().setAttribute("user",dbUser);
                result.setStatus(true);
                result.setMessage(JSONObject.toJSONString(dbUser));
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                result.setStatus(false);
                result.setMessage(e.getMessage());
                return result;
            }
        }
        result.setStatus(false);
        result.setMessage("验证码错误~~~");
        return result;
    }
}
