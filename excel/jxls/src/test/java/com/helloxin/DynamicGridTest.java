package com.helloxin;

import com.helloxin.domain.Employee;
import com.sun.org.apache.xalan.internal.utils.SecuritySupport;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
public class DynamicGridTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        try(InputStream is = SecuritySupport.getResourceAsStream("grid_template.xls")) {
            try(OutputStream os = new FileOutputStream("target/grid_output2.xls")) {
                Context context = new Context();
                context.putVar("headers", Arrays.asList("Name", "Birthday", "Payment"));
                context.putVar("data", generateSampleEmployeeData());
                JxlsHelper.getInstance().processGridTemplateAtCell(is, os, context, "name,birthDate,payment", "Sheet2!A1");
            }
        }
    }

    private List<Employee> generateSampleEmployeeData() {
        Employee employee = new Employee();
        employee.setBirthDate(new Date());
        employee.setBonus(new BigDecimal(0.01));
        employee.setName("helloxin");
        employee.setPayment(new BigDecimal(100000L));
        return Lists.newArrayList(employee);
    }
}
