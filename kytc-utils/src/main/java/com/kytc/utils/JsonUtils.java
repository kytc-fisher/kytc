package com.kytc.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	public static String toJSON(Object obj){
		if(obj==null){
			return "{}";
		}
		return JSON.toJSONString(obj);
	}
	public static <T> T change(Object obj,Class<T> t){
		return change(toJSON(obj),t);
	}
	public static <T> T change(String obj,Class<T> t){
		return JSON.parseObject(obj, t);
	}
	public static <T> List<T> toArray(String obj,Class<T> t){
		return JSON.parseArray(obj, t);
	}
}
