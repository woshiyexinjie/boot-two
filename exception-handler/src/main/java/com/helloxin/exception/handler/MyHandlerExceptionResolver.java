package com.helloxin.exception.handler;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver,Ordered {
	
	private static final Logger logger = LoggerFactory.getLogger(MyHandlerExceptionResolver.class);

	@ResponseBody
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception e) {
        logger.info("url = {}, exception message = {}", request.getRequestURI(), e.getMessage());
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url-xin", request.getRequestURL());
//        mav.setViewName("error");
//        return mav;
        
//        response.setContentType("application/json;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		try {
//			String JSONString = "{\n" + 
//					"    \"code\": 100,\n" + 
//					"    \"message\": \"发生错误\",\n" + 
//					"    \"url\": \"http://localhost:8080/hello\",\n" + 
//					"    \"data\": \"MyHandlerExceptionResolver\"\n" + 
//					"}";
//			response.getWriter().print(JSONString);
//			response.getWriter().flush();
//			response.getWriter().close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}        
//        return null;
        
        ModelAndView mv = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		mv.setView(view);
		mv.addObject("code", "100");
		mv.addObject("message", "发生错误");
		mv.addObject("url", request.getRequestURI());
		mv.addObject("date", "MyHandlerExceptionResolver");
		return mv;

    }
    public int getOrder(){
        // 表示此HandlerExceptionResolver的优先级最高
        return Ordered.HIGHEST_PRECEDENCE;
    }
	

}
