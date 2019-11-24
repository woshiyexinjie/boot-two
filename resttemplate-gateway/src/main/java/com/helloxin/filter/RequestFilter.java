package com.helloxin.filter;

import com.helloxin.proxy.RequestProxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yexin on 2019/11/22.
 */
public class RequestFilter implements Filter {

    RequestProxy requestProxy;

    public RequestFilter(RequestProxy requestProxy) {
        this.requestProxy = requestProxy;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("your filter");
        if(requestProxy.proxy((HttpServletRequest)request,(HttpServletResponse)response)){

        }else{
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
