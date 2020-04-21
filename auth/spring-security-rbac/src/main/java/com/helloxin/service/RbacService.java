package com.helloxin.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yebanxian on 2020/4/20.
 */
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
