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
import com.kytc.entity.base.RoleEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.RoleModel;
import com.kytc.service.base.IRoleService;

@Controller("roleController")
@RequestMapping("/role")
public class RoleController {
	private String ROOT_PATH = "/role/";
	@Autowired
	private IRoleService roleService;
	@RequestMapping(value={"","/index"},method=RequestMethod.GET)
	public String index(){
		return ROOT_PATH+"index";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public PageResult<RoleModel> list(HttpServletRequest request){
		Map<String,Object> params = CommonUtils.getRequestMap(request);
		return roleService.list(params);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return ROOT_PATH+"add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(RoleEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return roleService.add(entity);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model){
		ResultModel<RoleEntity> result = roleService.getById(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> update(RoleEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return roleService.update(entity);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(RoleEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return roleService.delete(entity);
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Integer id,Model model){
		ResultModel<RoleModel> result = roleService.detail(id);
		System.out.println(roleService.detail(id));
		model.addAttribute("result", result);
		return ROOT_PATH+"detail";
	}
}
