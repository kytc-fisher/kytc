package com.kytc.auth.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;

public class CommonUtils extends com.kytc.utils.CommonUtils {
	public static String getIpAddr(HttpServletRequest request) { 
        String ip = request.getHeader("x-forwarded-for"); 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        } 
        String[] ipArr = ip.split(",");
        for(String _ip:ipArr){
    	    if(_ip!=null&&!"".equals(_ip)&&!"unknown".equalsIgnoreCase(_ip)){
    		    return _ip;
    	    }
        }
        return ip; 
    }
	public static String getIp(){
		return (String) MDC.get("ip");
	}
	public static Map<String,Object> getRequestMap(HttpServletRequest request){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		Enumeration<?> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String str = (String)en.nextElement();
			returnMap.put(str, request.getParameter(str));
		}
		return returnMap;
	}
}
