package com.kytc.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kytc.system.shiro.SessionUtils;

public class ShiroSessionFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub

	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;  
        HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;  
        if (!SessionUtils.isLogin()) {
            //判断session里是否有用户信息  
            if (httpServletRequest.getHeader("x-requested-with") != null  
                    && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {  
                //如果是ajax请求响应头会有，x-requested-with  
            	httpServletResponse.setHeader("sessionstatus", "timeout");//在响应头设置session状态 
            	return;  
            }  
        }  
        arg2.doFilter(arg0, arg1);  

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}