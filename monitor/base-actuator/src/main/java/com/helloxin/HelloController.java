package com.helloxin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("hello")
    public Map sayHello(HttpServletResponse response) throws IOException {
        Map map = new HashMap();
        map.put("hello","xin");
        return map;
    }
}
