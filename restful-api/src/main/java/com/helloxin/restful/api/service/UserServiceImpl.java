package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.UserBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Override
    public UserBO getUserByUserId(String userId){
          log.info("userId ={}",userId);
          return UserBO.builder().userId(userId).userName("zhangsan_real").userPhone("17200102400").createTime(new Date()).updateTime(new Date()).build();
    }
}
