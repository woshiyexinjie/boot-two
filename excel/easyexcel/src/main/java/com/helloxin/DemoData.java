package com.helloxin;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    @ExcelProperty("字符串标题2")
    private String string2;
    @ExcelProperty("字符串标题3")
    private String string3;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}