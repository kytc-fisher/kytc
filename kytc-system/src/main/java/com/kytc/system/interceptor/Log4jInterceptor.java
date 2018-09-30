package com.kytc.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kytc.system.utils.CommonUtils;

public class Log4jInterceptor extends HandlerInterceptorAdapter {
	@Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {    
        MDC.put("ip", CommonUtils.getIpAddr(request));
        return true;
    }    
}
