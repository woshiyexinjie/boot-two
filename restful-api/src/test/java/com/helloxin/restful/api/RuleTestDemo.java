package com.helloxin.restful.api;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class RuleTestDemo {

    //使用Timeout这个Rule
    @Rule
    public Timeout timeout = new Timeout(1000);

    @Test
    public void testMethod1() throws Exception {
        Thread.sleep(1001);
    }

    @Test
    public void testMethod2() throws Exception {
        Thread.sleep(99);
    }
}
