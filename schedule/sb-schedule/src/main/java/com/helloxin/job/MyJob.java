package com.helloxin.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyJob {
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob() throws InterruptedException {
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >>fixedDelay执行....");
//        Thread.sleep(2000L);
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >>fixedDelay执行结束....");
//    }

    @Scheduled(fixedDelay = 100,initialDelay = 3000)
    @Async("detectTaskScheduler")
    public void asyncfixedDelayJob() throws InterruptedException {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >>fixedDelay执行....");
        Thread.sleep(5000L);
        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + " >>fixedDelay执行结束....");
    }
}
