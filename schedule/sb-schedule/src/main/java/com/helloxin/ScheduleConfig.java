package com.helloxin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Slf4j
@Configuration
public class ScheduleConfig {


//    @Bean("detectTaskScheduler")
//    public Executor detectTaskScheduler() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(1);
//        executor.setMaxPoolSize(1);
//        executor.setQueueCapacity(5);
//        //也是丢弃任务，但是不抛出异常
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
//        executor.initialize();
//        return executor;
//    }


    //这种情况
    //TODO 发现存在以下多个线程池的情况  会出现异步任务不能回收的情况
    @Bean("detectTaskScheduler")
    public TaskScheduler detectTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1);
        taskScheduler.setErrorHandler(t -> log.error("error when schedule task", t));
        return taskScheduler;
    }



    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1);
        return taskScheduler;
    }
//
//    @Bean("taskExecutor")
//    public Executor getExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(20);
//        executor.setMaxPoolSize(20);
//        executor.setQueueCapacity(20);
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        executor.initialize();
//        return executor;
//    }


}
