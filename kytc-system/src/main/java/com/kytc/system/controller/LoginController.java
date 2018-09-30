package com.kytc.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kytc.system.shiro.SessionUtils;
import com.kytc.entity.base.LoginEntity;
import com.kytc.utils.EncryptUtils;

@Controller("")
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request){
		request.setAttribute("errorMsg", "");
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(LoginEntity entity,HttpServletRequest request){
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(entity.getUserName(),EncryptUtils.md5(entity.getPassword()));
			try {  
                currentUser.login(token); 
                request.setAttribute("errorMsg", "");
            } catch (UnknownAccountException uae) { 
            	request.setAttribute("errorMsg", SessionUtils.getSession("loginError"));
            	SessionUtils.deleteSession("loginError");;
                return "login";  
            }
		}
		return "redirect:/index";
	}
}
