package com.helloxin.restful.api.work;

import com.helloxin.restful.api.bo.UserBO;
import com.helloxin.restful.api.service.UserService;
import com.jd.platform.async.callback.ICallback;
import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class DeWorker implements IWorker<String, UserBO>, ICallback<String, UserBO> {

    @Autowired
    private UserService userService;

    @Override
    public UserBO action(String userId, Map<String, WorkerWrapper> allWrappers) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getUserByUserId(userId);
    }


    @Override
    public UserBO defaultValue() {
        return UserBO.builder().userId("1").userName("zhangsan").userPhone("17200102300").createTime(new Date()).updateTime(new Date()).build();
    }

    @Override
    public void begin() {
        System.out.println(Thread.currentThread().getName() + "- start --" + System.currentTimeMillis());
    }

    @Override
    public void result(boolean success, String param, WorkResult<UserBO> workResult) {
        System.out.println("worker0 的结果是：" + workResult.getResult());
    }
}

