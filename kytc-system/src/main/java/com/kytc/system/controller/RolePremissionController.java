package com.kytc.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kytc.entity.base.RolePremissionEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.premission.ProjectModel;
import com.kytc.service.base.IRolePremissionService;

@Controller("rolePremissionController")
@RequestMapping("rolePremission")
public class RolePremissionController {
	
	@Autowired
	private IRolePremissionService rolePremissionService;
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(Integer roleId,Model model){
		List<ProjectModel> list = rolePremissionService.getPremissions(roleId);
		model.addAttribute("list", list);
		model.addAttribute("id", roleId);
		return "/premission/premission";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(RolePremissionEntity entity){
		return rolePremissionService.add(entity);
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(RolePremissionEntity entity){
		return rolePremissionService.delete(entity);
	}
}
