package com.helloxin;

import org.casbin.jcasbin.main.Enforcer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {


    @Autowired
    Enforcer enforcer;

    @Test
    public void testTrancferFicusAnnoToKakapo() {

        //Enforcer enforcer = new Enforcer("casbin/basic_model.conf", "casbin/basic_policy.csv");
        String sub = "alice";
        String obj = "data1";
        String act = "read";

        if (enforcer.enforce(sub, obj, act) == true) {
            System.out.println("permit alice to read data1");
        } else {
            System.out.println("deny the request, show an error");
        }
    }
}