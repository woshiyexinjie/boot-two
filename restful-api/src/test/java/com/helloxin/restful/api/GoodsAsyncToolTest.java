package com.helloxin.restful.api;

import com.helloxin.restful.api.bo.UserBO;
import com.helloxin.restful.api.work.DeWorker;
import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class GoodsAsyncToolTest {

    @Autowired
    DeWorker deWorker;

    @Test
    public void should_get_goods_info_then_success() throws ExecutionException, InterruptedException {

        WorkerWrapper<String, UserBO> workerWrapper = new WorkerWrapper.Builder<String, UserBO>()
                .worker(deWorker)
                .param("12345")
                .id("first")
                .callback(deWorker)
                .build();
        Async.beginWork(3500, workerWrapper);
        System.out.println(workerWrapper.getWorkResult());
        Async.shutDown();
    }
}
