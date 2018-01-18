package com.xt.hshe.core.web;

import com.xt.hshe.core.util.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class AuthInterceptor implements HandlerInterceptor {


    @Autowired
    private StringRedisTemplate template;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.matches("/error")) return true;

        //根目录进Handler控制跳转
        if (uri.equals("/")) return true;

        //注册登录的直接放行
        String authRgx = "/auth[a-zA-Z_0-9/]*";
        if (uri.matches(authRgx) || uri.equals("/login")) {
            return true;
        }


        String token = request.getHeader("token");


        //没有token
        if (token==null||"".equals(token)){
            response.setStatus(401);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<center>401 Unauthorized: No Token.</center><hr/><center>请登录系统 <a href=\"/login\">登录</a></center>");
            return false;
        }

        String info = AES.Decrypt(token, template.opsForValue().get("sKey"));



        //token 非法
        String tokenRgx = "[studenachr]{7}+#[0-9]{8,9}#[0-9]{13}";//教师工号可以8-9位
        if (info==null || !info.matches(tokenRgx)){
            response.setStatus(401);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<center>401 Unauthorized: llegal Token.</center><hr/><center>非法请求，请重新登录 <a href=\"/login\">登录</a></center>");
            return false;
        }


        String[] infos = info.split("#");


        //token 过期
        long inTime = Long.parseLong(infos[2]);
        long nowTime = System.currentTimeMillis();
        if (TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS)<nowTime-inTime){
            response.setStatus(401);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<center>401 Unauthorized: Token Expired.</center><hr/><center>登录过期，请重新登录 <a href=\"/login\">登录</a></center>");
            return false;
        }

        //学生访问教师
        //访问权限检查用切面做，更方便
//        String teaRgx = "/teacher[a-zA-Z_0-9/]*";
//        if ("student".equals(infos[0]) && uri.matches(teaRgx)){
//            response.setStatus(403);
//            response.setContentType("text/html;charset=UTF-8");
//            response.getWriter().print("<center>403 Forbidden: Not authorized.</center><hr/><center>无权访问</center>");
//            return false;
//        }
        request.setAttribute("role", infos[0]);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
