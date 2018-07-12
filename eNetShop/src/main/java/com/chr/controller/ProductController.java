package com.chr.controller;

import com.chr.entity.Product;
import com.chr.entity.Result;
import com.chr.entity.Tag;
import com.chr.service.ProductService;
import com.chr.util.POI_Util;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    private Result result = new Result();

    @RequestMapping("/queryAll")
    public Map<String,Object> queryAll(Integer page, Integer rows){
        PageInfo<Product> pageInfo = productService.findAll(page, rows);
        List<Product> products = pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String,Object> result = new HashMap<>();
        result.put("rows",products);
        result.put("total",total);
        return result;
    }

    @RequestMapping("/save")
    public Result save(Product product, String tagid, MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            //相对路径获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            String originalFilename = file.getOriginalFilename();//获取文件名
            System.out.println(originalFilename);
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString();
            String newName = uuid+"."+split[1];
            file.transferTo(new File(realPath,newName));
            product.setPath("\\upload\\"+newName);
        }
        productService.add(product,tagid);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/cancel")
    public Result cancel(String id, HttpServletRequest request){
        Product product = productService.findOne(id);
        String realPath = request.getSession().getServletContext().getRealPath(product.getPath());
        File file = new File(realPath);
        file.delete();
        productService.remove(id);
        result.setStatus(true);
        return result;
    }

    @RequestMapping("/alter")
    public Result alter(Product product, MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            //相对路径获取绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            String originalFilename = file.getOriginalFilename();//获取文件名
            System.out.println(originalFilename);
            String[] split = originalFilename.split("\\.");
            String uuid = UUID.randomUUID().toString();
            String newName = uuid+"."+split[1];
            file.transferTo(new File(realPath,newName));
            String oldRealPath = request.getSession().getServletContext().getRealPath(product.getPath());
            File oldfile = new File(oldRealPath);
            oldfile.delete();
            product.setPath("\\upload\\"+newName);
        }
        productService.modify(product);
        return result;
    }

    @RequestMapping("/queryOne")
    public Product queryOne(String id){
        return productService.findOne(id);
    }

    @RequestMapping("/cancelAll")
    public Result cancelAll(String[] ids,HttpServletRequest request){
        System.out.println("*******");
        List<String> strings = Arrays.asList(ids);
        for (String string : strings) {
            Product product = productService.findOne(string);
            String realPath = request.getSession().getServletContext().getRealPath(product.getPath());
            File file = new File(realPath);
            file.delete();
        }
        productService.removeAll(strings);
        result.setStatus(true);
        result.setMessage("删除成功~~~");
        return result;
    }

    @RequestMapping("/queryTag")
    public List<Tag> queryTag(String id){
        return productService.findTag(id);
    }

    @RequestMapping("/addTag")
    public Result addTag(String proid, String tagid){
        productService.addTag(proid, tagid);
        result.setStatus(true);
        result.setMessage("添加成功~~~");
        return result;
    }

    @RequestMapping("/delTag")
    public Result delTag(String proid, String tagid) {
        productService.delTag(proid, tagid);
        result.setStatus(true);
        result.setMessage("删除成功~~~");
        return result;
    }

    @RequestMapping("/outPutProductAsExcel")
    public void outPutProductAsExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Product> products = productService.All();

        HSSFWorkbook workbook = POI_Util.getPOI(products, "商品", "商品");

        //设置响应类型
        String mimeType = request.getSession().getServletContext().getMimeType(".xls");
        response.setContentType(mimeType);
        //设置响应方式 响应头 attachment附件下载 inline在线打开
        response.setHeader("content-disposition","attachment;fileName=" + URLEncoder.encode("excel.xls","UTF-8"));
        //获取输出流
        OutputStream os = response.getOutputStream();

        workbook.write(os);
        os.close();
        workbook.close();
    }

    @RequestMapping("/search")
    public List<Product> search(String keywords){

        return productService.findProductByName(keywords);

    }


}
