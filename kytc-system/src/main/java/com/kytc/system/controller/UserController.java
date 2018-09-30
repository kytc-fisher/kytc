package com.kytc.system.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kytc.system.shiro.SessionUtils;
import com.kytc.system.utils.CommonUtils;
import com.kytc.entity.base.UserEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.UserModel;
import com.kytc.service.base.IUserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	private String ROOT_PATH = "/user/";
	@Autowired
	private IUserService userService;
	@RequestMapping(value={"","/index"},method=RequestMethod.GET)
	public String index(){
		return ROOT_PATH+"index";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public PageResult<UserModel> list(HttpServletRequest request){
		Map<String,Object> params = CommonUtils.getRequestMap(request);
		return userService.list(params);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return ROOT_PATH+"add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<Object> add(UserEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return userService.add(entity);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model){
		ResultModel<UserEntity> result = userService.getById(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<Object> update(UserEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return userService.update(entity);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<Object> delete(UserEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return userService.delete(entity);
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Integer id,Model model){
		ResultModel<UserModel> result = userService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"detail";
	}
}
