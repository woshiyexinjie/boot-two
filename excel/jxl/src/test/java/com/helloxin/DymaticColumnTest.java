package com.helloxin;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class DymaticColumnTest {


    private static final String EXCEL_FILE_LOCATION = "./MyFirstExcel.xls";

    /**
     * Rigorous Test :-)
     */
    @Test
    public void baseJxlTest() throws IOException, WriteException {
        String url = EXCEL_FILE_LOCATION;
        InsertExcelClo(url);
    }

    public static void InsertExcelClo(String url) {
        //插入列 写起来太麻烦了
        File file = new File(url);
        if (!file.exists()) {
            System.out.println("文件不存在");
        }
        Workbook wb = null;
        WritableWorkbook wwb = null;
        try {
            wb = Workbook.getWorkbook(file);
            wwb = Workbook.createWorkbook(file);
            Sheet old_sheet = wb.getSheet(0);
            String old_name = old_sheet.getName();
            int cols = old_sheet.getColumns();
            int rows = old_sheet.getRows();
            WritableSheet new_sheet = wwb.createSheet(old_name, 0);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols + 1; j++) {
                    if (j == 0) {
                        if (i == 0) {
                            Label label = new Label(0, 0, "xx");
                            new_sheet.addCell(label);
                        } else if (i == 1) {
                            Label label = new Label(0, 1, "xxx");
                            new_sheet.addCell(label);
                        } else {
                            Label label = new Label(0, i, "");
                            new_sheet.addCell(label);
                        }
                    } else {
                        Cell cell = old_sheet.getCell(j - 1, i);
                        String str = cell.getContents().equals("") ? "" : cell.getContents();
                        Label label = new Label(j, i, str);
                        new_sheet.addCell(label);
                    }
                }
            }
            wwb.write();
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
                if (wwb != null) {
                    wwb.close();
                }
            } catch (Exception e) {
                System.out.println("关闭异常");
                e.printStackTrace();
            }
        }
    }
}

