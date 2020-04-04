package com.helloxin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
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

    @GetMapping("mulDownload")
    public void mulDownload(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        // 去调用写入,这里我调用了五次，实际使用时根据据库分页的总的页数来。这里最终会写到5个sheet里面

        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
        for (int i = 0; i < 5; i++) {
//             每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.clas 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
            WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(DemoData.class).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<DemoData> data = dataDemo();
            excelWriter.write(data, writeSheet);
        }
        excelWriter.finish();

    }

    private List<DemoData> dataDemo() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
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
