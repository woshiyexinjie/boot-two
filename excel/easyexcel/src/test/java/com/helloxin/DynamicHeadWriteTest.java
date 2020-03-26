package com.helloxin;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class DynamicHeadWriteTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String fileName =  "dynamicHeadWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName)
                // 这里放入动态头
                .head(head()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(data());

    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = new ArrayList<String>();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = new ArrayList<String>();
        head2.add("日期" + System.currentTimeMillis());
        List<String> head3 = new ArrayList<String>();
        head3.add("2字符串" + System.currentTimeMillis());
        List<String> head4 = new ArrayList<String>();
        head4.add("3字符串" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        return list;
    }

    private List<List<Object>> data() {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> alist = new ArrayList<>();
            alist.add("字符串" + i);
            alist.add(new Date());
            alist.add(null);
            alist.add(null);
            alist.add("3字符串" + i);
            list.add(alist);
        }
        return list;
    }
}
