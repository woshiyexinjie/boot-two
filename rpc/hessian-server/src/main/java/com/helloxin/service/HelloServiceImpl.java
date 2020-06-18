package com.helloxin.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by yebanxian on 2020/6/18.
 */
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        log.info("hello {}",name);
        return "you are lucky";
    }
}
