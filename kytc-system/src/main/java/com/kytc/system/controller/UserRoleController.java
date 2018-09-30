package com.kytc.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kytc.entity.base.UserRoleEntity;
import com.kytc.model.ResultModel;
import com.kytc.service.base.IUserRoleService;

@Controller("userRoleController")
@RequestMapping("userRole")
public class UserRoleController {
	private String ROOT_PATH = "/userRole/";
	@Autowired
	private IUserRoleService userRoleService;
	@RequestMapping("index")
	public String index(Integer userId,Integer departmentId,Model model){
		Map<String,Object> map = userRoleService.list(userId, departmentId);
		model.addAttribute("data", map);
		model.addAttribute("userId", userId);
		return ROOT_PATH + "index";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(UserRoleEntity entity){
		return userRoleService.add(entity);
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(UserRoleEntity entity){
		return userRoleService.delete(entity);
	}
}
