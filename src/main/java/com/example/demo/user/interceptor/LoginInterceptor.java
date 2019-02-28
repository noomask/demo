package com.example.demo.user.interceptor;

import com.example.demo.common.Const;
import com.example.demo.common.dto.DTOs;
import com.example.demo.user.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        path = path.substring("/demo/api".length());
        System.out.println(path);
        if(path.equals("/users/login") || path.equals("/users/register")){
            return true;
        }
        Object obj = session.getAttribute(Const.USERINFO);
        if(ObjectUtils.isEmpty(obj)){
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(DTOs.getJson(false, "请登陆后访问"));
            response.setStatus(401);
            response.addHeader("content-type", "application/json;charset=UTF-8");
            response.getWriter().println(result);
            return false;
        }
        return true;
    }

}
