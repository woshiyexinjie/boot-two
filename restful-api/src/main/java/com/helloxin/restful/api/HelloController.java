package com.helloxin.restful.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by yexin on 2019/11/22.
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public List<String> sayHello() {
        return Collections.singletonList("Hello world!");
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public Boolean uploadFile(@RequestParam("file") MultipartFile file) {
        log.info("file size={}",file.getSize());
        return Boolean.TRUE;
    }

    @RequestMapping(value = "/downFile", method = RequestMethod.POST)
    public void downFile(String fileName, HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        File file = new File("/Users/yexinjie/HTTP Request.jmx");
        FileInputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
        byte data[] = new byte[length];
        inputStream.read(data);
        outputStream.write(data);
        outputStream.close();
    }
}
