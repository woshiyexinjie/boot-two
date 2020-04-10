package com.helloxin;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    //接受json数据 不能使用 @RequestParam("myjson")JSONObject jsonObject
    @PostMapping(value = "hello")
    @ResponseBody
    public Task hello(@RequestBody JSONObject jsonObject){
//        log.info(jsonObject.toJSONString());
        return Task.builder().cost(100).days(4).taskName("iliad").build();
    }
}
