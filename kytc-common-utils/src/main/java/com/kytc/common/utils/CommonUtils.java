package com.kytc.common.utils;

import com.kytc.common.model.ResultModel;

public class CommonUtils {
	public static <T> ResultModel<T> returnModel(Boolean state,String reason,T t){
		ResultModel<T> result = new ResultModel<T>(state,reason,t);
		return result;
	}
	public static <T> ResultModel<T> returnModel(Boolean state,String reason){
		ResultModel<T> result = new ResultModel<T>(state,reason,null);
		return result;
	}
	public static <T> ResultModel<T> returnModel(T t){
		ResultModel<T> result = new ResultModel<T>(true,null,t);
		return result;
	}
	public static <T> ResultModel<T> returnModel(String reason){
		ResultModel<T> result = new ResultModel<T>(false,reason,null);
		return result;
	}
}
