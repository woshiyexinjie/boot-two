package com.helloxin;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test{
    @Autowired
    private Enforcer enforcer;
}
