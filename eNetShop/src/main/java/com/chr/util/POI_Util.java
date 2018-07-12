package com.chr.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class POI_Util {

    public static <T>HSSFWorkbook getPOI( List<T> objs, String workbookname, String titlename) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        T obj = objs.get(0);

        Class<? extends T> objClass = (Class<? extends T>) obj.getClass();

        Field[] declaredFields = objClass.getDeclaredFields();

        //创建hssfworkbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建工作簿
        HSSFSheet sheet = workbook.createSheet(workbookname);


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

        cell.setCellValue(titlename);

        //创建副标题列
        HSSFRow titleRow = sheet.createRow(1);

        for (int i = 0; i <declaredFields.length ; i++) {
            HSSFCell titleCell = titleRow.createCell(i);
            titleCell.setCellStyle(cellStyle);
            titleCell.setCellValue(declaredFields[i].getName());//给当前单元格设置字段名称

        }

        //创建数据列
        for (int i = 0; i < objs.size() ; i++) {
            HSSFRow dataRow = sheet.createRow(i+2);

            //遍历对象的字段
            for (int j = 0; j < declaredFields.length ; j++) {

                HSSFCell fieldCell = dataRow.createCell(j);
                fieldCell.setCellStyle(cellStyle);

                //反射获取信息
                String getMethodName = "get"+declaredFields[j].getName().substring(0,1).toUpperCase()
                        + declaredFields[j].getName().substring(1);

                //调用方法
                Method declaredMethod = objClass.getDeclaredMethod(getMethodName, new Class[]{});
                //指定GET方法
                Object invoke =  declaredMethod.invoke(objs.get(i), new Object[]{});

                if(invoke.getClass() == Date.class){
                    fieldCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(invoke));
                }else {

                    fieldCell.setCellValue(invoke.toString());
                }
            }

        }

        return workbook;
    }

}
