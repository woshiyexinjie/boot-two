package com.helloxin;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by yexin on 2019/11/22.
 */
@RestController
@Slf4j
public class HelloController {

    final  static  Integer  insertIndex =1;

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<ExcelCell> reportCig = ReportExcelInfo.getReportCig();
        List<ExcelCell> customCig = getCustomCig();

        reportCig.addAll(insertIndex, customCig);
        EasyExcel.write(response.getOutputStream()).head(head(reportCig)).sheet("模板").doWrite(finaldata());
    }

    private List<List<String>> head(List<ExcelCell> finalExcelCig) {
        List<List<String>> list = new ArrayList<List<String>>();
        for(ExcelCell excelCell:finalExcelCig){
            List<String> head0 = new ArrayList<String>();
            head0.add(excelCell.getName());
            list.add(head0);
        }
        return list;
    }

    private List<ExcelCell> getCustomCig() {
        ExcelCell excelCell = new ExcelCell("收入");
        return Collections.singletonList(excelCell);
    }

    private List<List<Object>> finaldata() {
        List<List<Object>> data = data();
        List<List<Object>> customData = customData();
        mergeData(data,customData,insertIndex);
        return data;
    }

    private void mergeData(List<List<Object>> data, List<List<Object>> customData, Integer insertIndex) {
        int size = data.size()>customData.size() ? customData.size():data.size();
        for(int i=0;i<size;i++){
            data.get(i).addAll(insertIndex,customData.get(i));
        }
    }

    private List<List<Object>> data() {
        List<Object> list = new ArrayList<>();
        list.add("hello");
        list.add(14);
        list.add("hello world");
        list.add(100000);
        list.add(new Date());
        List<List<Object>>  mlist = new ArrayList<>();
        mlist.add(list);
        return  mlist;
    }

    private List<List<Object>> customData() {
        List<Object> list = new ArrayList<>();
        list.add(135000);
        List mlist = new ArrayList<>();
        mlist.add(list);
        return  mlist;
    }
}
