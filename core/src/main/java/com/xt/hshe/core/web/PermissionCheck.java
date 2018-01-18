package com.xt.hshe.core.web;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@Aspect
public class PermissionCheck {

    @Pointcut("execution(* com.xt.hshe.core.web.controller.*.T*(..))")
    public void invoke(){}

    /**
     * 在这之前已经过了AuthInterceptor，token合法检查过了
     *
     */
    @Around("invoke()")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        if (!"teacher".equals(request.getAttribute("role"))){
            response.setStatus(403);
            response.setContentType("text/html;charset=UTF-8");
            try(PrintWriter writer = response.getWriter()){
                writer.print("<center>403 Forbidden: Not authorized.</center><hr/><center>无权访问</center>");
            }
            return null;
        }
        return pjp.proceed(args);
    }
}
