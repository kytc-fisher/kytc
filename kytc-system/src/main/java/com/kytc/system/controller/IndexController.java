package com.kytc.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kytc.system.shiro.SessionUtils;

@Controller("")
public class IndexController {
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request){
		if(SessionUtils.isLogin()){
			return "index";
		}
		return "redirect:/login";
	}
}
