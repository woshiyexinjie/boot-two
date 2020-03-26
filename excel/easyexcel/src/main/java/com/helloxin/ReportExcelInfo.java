package com.helloxin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yebanxian on 2020/3/23.
 */
public class ReportExcelInfo {

    public static List<ExcelCell> getReportCig(){
        List<ExcelCell> list = new ArrayList<>();
        ExcelCell nameCell = new ExcelCell("名字");
        list.add(nameCell);
        ExcelCell ageCell = new ExcelCell("年龄");
        list.add(ageCell);
        ExcelCell descCell = new ExcelCell("描述");
        list.add(descCell);
        ExcelCell payCell = new ExcelCell("支付");
        list.add(payCell);
        ExcelCell createCell = new ExcelCell("下单时间");
        list.add(createCell);
        return list;
    }
}
