package com.xt.hshe.core.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.util.Consts;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * AOP权限检查
 *
 * @author Shawn Chen
 */
@Component
@Aspect
public class PermissionCheck {

    private final ObjectMapper objectMapper;

    @Autowired
    public PermissionCheck(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

//    @Pointcut("execution(* com.xt.hshe.core.web.controller.*.T*(..))")
//    public void invoke(){}

    @Pointcut("@annotation(com.xt.hshe.core.annotation.TeacherRequired)")
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
        if (!Consts.Role.TEACHER.equals(request.getAttribute("role"))){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType("application/json;charset=UTF-8");
            try(PrintWriter writer = response.getWriter()){
                writer.print(objectMapper.writeValueAsString(new HttpMsg(Consts.ServerCode.FAILURE, "无权访问")));
            }
            return null;
        }
        return pjp.proceed(args);
    }
}
