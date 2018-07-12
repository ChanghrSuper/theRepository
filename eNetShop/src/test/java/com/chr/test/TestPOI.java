package com.chr.test;


import com.chr.Application;
import com.chr.entity.Product;
import com.chr.service.ProductService;
import com.chr.util.POI_Util;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestPOI {

    @Resource
    private ProductService productService;

    @Test
    public void testPOI_Util() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {

        List<Product> products = productService.All();

        /*ProductOut pout = new ProductOut();
        List<ProductOut> productOuts = new ArrayList<>();
        for (Product p : products) {
            ProductOut out = new ProductOut();
            out.setId(p.getId());
            out.setName(p.getName());
            out.setPrice(p.getPrice());
            out.setDiscount(p.getDiscount());
            out.setDescription(p.getDescription());
            out.setTags(p.getTags());
            productOuts.add(out);
        }*/

        HSSFWorkbook workbook = POI_Util.getPOI(products, "商品", "商品");

        //将excel输出到哪个文件中
        FileOutputStream stream = new FileOutputStream(new File("H:/a.xls"));
        workbook.write(stream);
        stream.close();
        workbook.close();


    }

    @Test
    public void testpoi() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {

        ProductOut pout = new ProductOut();
        List<Product> products = productService.All();

        List<ProductOut> productOuts = new ArrayList<>();
        for (Product p : products) {
            ProductOut out = new ProductOut();
            out.setId(p.getId());
            out.setName(p.getName());
            out.setPrice(p.getPrice());
            out.setDiscount(p.getDiscount());
            out.setDescription(p.getDescription());
            out.setTags(p.getTags());
            productOuts.add(out);
        }


        Field[] declaredFields = pout.getClass().getDeclaredFields();

        //创建hssfworkbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建工作簿
        HSSFSheet sheet = workbook.createSheet("商品信息汇总");


        //合并单元格
        //参数1:起始行 参数2:结束行  参数3:起始列  参数4:结束列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, declaredFields.length-1));
        //修改行间距
        sheet.setDefaultColumnWidth(18);


        //创建标题行
        HSSFRow row = sheet.createRow(0);
        //创建标题列
        HSSFCell cell = row.createCell(0);


        //创建单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置对齐方式

        HSSFFont font = workbook.createFont(); //创建字符
        font.setFontHeightInPoints((short) 18);//设置字体大小
        cellStyle.setFont(font); //设置字体

        cellStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
        cell.setCellStyle(cellStyle);

        cell.setCellValue("商品信息汇总");

        //id name  age bir

        //创建副标题列
        HSSFRow titleRow = sheet.createRow(1);

        for (int i = 0; i <declaredFields.length ; i++) {
            HSSFCell titleCell = titleRow.createCell(i);
            titleCell.setCellStyle(cellStyle);
            titleCell.setCellValue(declaredFields[i].getName());//给当前单元格设置字段名称

        }

        //创建数据列
        for (int i = 0; i < productOuts.size() ; i++) {
            HSSFRow dataRow = sheet.createRow(i+2);

            //遍历对象的字段
            for (int j = 0; j < declaredFields.length ; j++) {

                HSSFCell fieldCell = dataRow.createCell(j);
                fieldCell.setCellStyle(cellStyle);

                //反射获取信息
                String getMethodName = "get"+declaredFields[j].getName().substring(0,1).toUpperCase()
                        + declaredFields[j].getName().substring(1);

                //调用方法
                Method declaredMethod = ProductOut.class.getDeclaredMethod(getMethodName, new Class[]{});
                //指定GET方法
                Object invoke =  declaredMethod.invoke(productOuts.get(i), new Object[]{});

                if(invoke.getClass() == Date.class){
                    fieldCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(invoke));
                }else {

                    fieldCell.setCellValue(invoke.toString());
                }
            }

        }

        //将excel输出到哪个文件中
        FileOutputStream stream = new FileOutputStream(new File("H:/a.xls"));
        workbook.write(stream);
        stream.close();
        workbook.close();


    }

    @Test
    public void testuser() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {

        List<User> users = new ArrayList<User>();
        User user = new User("21","小黑",23,new Date());
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);



        Field[] declaredFields = user.getClass().getDeclaredFields();

        //创建hssfworkbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建工作簿
        HSSFSheet sheet = workbook.createSheet("商品信息汇总");


        //合并单元格
        //参数1:起始行 参数2:结束行  参数3:起始列  参数4:结束列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, declaredFields.length-1));
        //修改行间距
        sheet.setDefaultColumnWidth(18);


        //创建标题行
        HSSFRow row = sheet.createRow(0);
        //创建标题列
        HSSFCell cell = row.createCell(0);


        //创建单元格样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置对齐方式

        HSSFFont font = workbook.createFont(); //创建字符
        font.setFontHeightInPoints((short) 18);//设置字体大小
        cellStyle.setFont(font); //设置字体

        cellStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
        cell.setCellStyle(cellStyle);

        cell.setCellValue("商品信息汇总");

        //id name  age bir


        //创建副标题列
        HSSFRow titleRow = sheet.createRow(1);

        for (int i = 0; i <declaredFields.length ; i++) {
            HSSFCell titleCell = titleRow.createCell(i);
            titleCell.setCellStyle(cellStyle);
            titleCell.setCellValue(declaredFields[i].getName());//给当前单元格设置字段名称

        }


        //创建数据列
        for (int i = 0; i < users.size() ; i++) {
            HSSFRow dataRow = sheet.createRow(i+2);

            //遍历对象的字段
            for (int j = 0; j < declaredFields.length ; j++) {

                HSSFCell fieldCell = dataRow.createCell(j);
                fieldCell.setCellStyle(cellStyle);

                //反射获取信息
                String getMethodName = "get"+declaredFields[j].getName().substring(0,1).toUpperCase()
                        + declaredFields[j].getName().substring(1);

                //调用方法
                Method declaredMethod = User.class.getDeclaredMethod(getMethodName, new Class[]{});
                //指定GET方法
                Object invoke = declaredMethod.invoke(users.get(i), new Object[]{});

                if(invoke.getClass() == Date.class){
                    fieldCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(invoke));
                }else {

                    fieldCell.setCellValue(invoke.toString());
                }
            }

        }

        //将excel输出到哪个文件中
        FileOutputStream stream = new FileOutputStream(new File("H:/a.xls"));
        workbook.write(stream);
        stream.close();
        workbook.close();

    }


}
