package com.xt.hshe.core.web;

import com.sun.deploy.net.HttpResponse;
import com.xt.hshe.core.pojo.HttpMsg;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 全局异常处理器
 *
 * @author Shawn Chen
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpMsg<String> errorHandler(HttpServletResponse response, Exception e){
        e.printStackTrace();
//        return new HttpMsg<>(0,"系统异常-"+e.getClass().getName());
        return new HttpMsg<>(0,"系统异常-"+e.getMessage());

    }
}
