package com.chr.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        //相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //获取文件名
        System.out.println("name属性名："+file.getName());
        System.out.println("文件名："+file.getOriginalFilename());
        //获取文件类型
        System.out.println("文件类型："+file.getContentType());

        //处理上传操作
        file.transferTo(new File(realPath,file.getOriginalFilename()));

        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public String download(String filename,HttpServletRequest request, HttpServletResponse response) throws Exception {
        //相对路劲获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //获取文件输入流
        InputStream is = new FileInputStream(new File(realPath, filename));
        //设置响应类型
        String mimeType = request.getSession().getServletContext().getMimeType("." + FilenameUtils.getExtension(filename));
        response.setContentType(mimeType);
        //设置响应方式 响应头 attachment附件下载 inline在线打开
        response.setHeader("content-disposition","inline;fileName=" + URLEncoder.encode(filename,"UTF-8"));
        //获取输出流
        OutputStream os = response.getOutputStream();
        //下载文件
        IOUtils.copy(is,os);
        //关闭资源
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
        return null;
    }

}
