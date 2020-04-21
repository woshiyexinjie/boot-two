package com.helloxin;

import com.alibaba.fastjson.JSON;
import com.helloxin.common.Grant;
import com.helloxin.service.AuthService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api("swagger ui 注释 AuthController")
@RestController
@Slf4j
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/addPolicy")
    ResponseEntity<String> addPolicy(@RequestBody Grant grant) {
        try {
            authService.addPolicy(grant);
            return new ResponseEntity<>(JSON.toJSONString(null, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
