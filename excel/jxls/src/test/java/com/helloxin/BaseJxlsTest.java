package com.helloxin;

import com.helloxin.domain.Employee;
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
import java.util.Date;
import java.util.List;

import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getResourceAsStream;

@Slf4j
public class BaseJxlsTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        log.info("Running Object Collection demo");
        List<Employee> employees = generateSampleEmployeeData();
        try(InputStream is = getResourceAsStream("object_collection_template.xls")) {
            try (OutputStream os = new FileOutputStream("target/object_collection_output.xls")) {
                Context context = new Context();
                context.putVar("employees", employees);
//                JxlsHelper.getInstance().processTemplate(is, os, context);
                JxlsHelper.getInstance().processTemplateAtCell(is, os, context, "Result!A1");

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
