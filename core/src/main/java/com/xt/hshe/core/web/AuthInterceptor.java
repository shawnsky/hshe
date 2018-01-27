package com.xt.hshe.core.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.util.AES;
import com.xt.hshe.core.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class AuthInterceptor implements HandlerInterceptor {


    @Autowired
    private ObjectMapper objectMapper;

    @Value("${token.skey}")
    private String sKey;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String uri = request.getRequestURI();
        System.out.println(uri);
        //页面模板请求都放行，API请求都拦截
        if (uri.matches("/api/[a-zA-Z_0-9/]*")){
            //注册登录的请求直接放行
            if (uri.matches("/api/auth[a-zA-Z_0-9/]*")) {
                return true;
            }
            String token = request.getHeader("Access-Token");
            //没有token
            if (token==null||"".equals(token)){
//                response.setStatus(401);
//                response.setContentType("text/html;charset=UTF-8");
//                response.getWriter().print("<center>401 Unauthorized: No Token.</center><hr/><center>请登录系统 <a href=\"/login\">登录</a></center>");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json;charset=UTF-8");
                try(PrintWriter writer = response.getWriter()){
                    writer.print(objectMapper.writeValueAsString(new HttpMsg(Consts.ServerCode.FAILURE, "请登录系统")));
                }
                return false;
            }

            String info = AES.Decrypt(token, sKey);//格式 student#140705202#1456789123456
            //token 非法
            String tokenRgx = "[studenachr]{7}+#[0-9]{8,9}#[0-9]{13}";//教师工号可以8-9位
            if (info==null || !info.matches(tokenRgx)){
//                response.setStatus(400);
//                response.setContentType("text/html;charset=UTF-8");
//                response.getWriter().print("<center>400 Unauthorized: llegal Token.</center><hr/><center>非法请求，请重新登录 <a href=\"/login\">登录</a></center>");
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setContentType("application/json;charset=UTF-8");
                try(PrintWriter writer = response.getWriter()){
                    writer.print(objectMapper.writeValueAsString(new HttpMsg(Consts.ServerCode.FAILURE, "非法请求，请重新登录")));
                }
                return false;
            }

            String[] infos = info.split("#");
            //token 过期
            long inTime = Long.parseLong(infos[2]);
            long nowTime = System.currentTimeMillis();
            if (TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS)<nowTime-inTime){
//                response.setStatus(401);
//                response.setContentType("text/html;charset=UTF-8");
//                response.getWriter().print("<center>401 Unauthorized: Token Expired.</center><hr/><center>登录过期，请重新登录 <a href=\"/login\">登录</a></center>");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json;charset=UTF-8");
                try(PrintWriter writer = response.getWriter()){
                    writer.print(objectMapper.writeValueAsString(new HttpMsg(Consts.ServerCode.FAILURE, "登录过期，请重新登录")));
                }
                return false;
            }
            //设置给AOP权限检查使用，避免再解析一次token
            request.setAttribute("role", infos[0]);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
