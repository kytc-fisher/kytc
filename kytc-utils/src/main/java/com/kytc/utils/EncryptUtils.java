package com.kytc.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author 何志同
 * @description 加密
 * @date 2017年5月21日上午10:07:51 
 */
public class EncryptUtils {
	public static String md5(String str){
		try {
			return new String(DigestUtils.md5Hex(str.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
