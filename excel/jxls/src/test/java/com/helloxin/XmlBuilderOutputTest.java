package com.helloxin;

import com.helloxin.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xml.XmlAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.TransformerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getResourceAsStream;

@Slf4j
public class XmlBuilderOutputTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        List<Employee> employees = generateSampleEmployeeData();
        try(InputStream is = getResourceAsStream("object_collection_xmlbuilder_template.xls")) {
            try (OutputStream os = new FileOutputStream("target/object_collection_xmlbuilder_output.xls")) {
                Transformer transformer = TransformerFactory.createTransformer(is, os);
                try (InputStream configInputStream = getResourceAsStream("object_collection_xmlbuilder.xml")) {
                    AreaBuilder areaBuilder = new XmlAreaBuilder(configInputStream, transformer);
                    List<Area> xlsAreaList = areaBuilder.build();
                    Area xlsArea = xlsAreaList.get(0);
                    Context context = new Context();
                    context.putVar("employees", employees);
                    xlsArea.applyAt(new CellRef("Result!A1"), context);
                    transformer.write();
                }
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
