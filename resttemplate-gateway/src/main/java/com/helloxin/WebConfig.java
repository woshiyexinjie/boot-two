package com.helloxin;

import com.helloxin.filter.RequestFilter;
import com.helloxin.proxy.RequestProxy;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yexin on 2019/11/22.
 */

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestFilter(requestProxy()));
        registration.addUrlPatterns("/*");
        registration.setName("RequestFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public RequestProxy requestProxy(){
        return new RequestProxy();
    }
}
