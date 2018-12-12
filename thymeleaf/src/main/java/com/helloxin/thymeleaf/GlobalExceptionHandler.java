package com.helloxin.thymeleaf;

import com.helloxin.thymeleaf.dto.ErrorDto;
import com.helloxin.thymeleaf.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        log.info("error msg e={}",e);
        mav.addObject("exception", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ErrorDto<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
      	ErrorDto<String> r = new ErrorDto<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorDto.ERROR);
        r.setData("Some Data");
        r.setSuccess(false);
        return r;
    }

}
