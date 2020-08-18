package com.helloxin.restful.api.service;

import com.helloxin.restful.api.bo.UserBO;

/**
 * Created by yebanxian on 2020/8/11.
 */
public interface UserService {
    UserBO getUserByUserId(String userId);
}
