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
import com.kytc.entity.base.PremissionEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.PremissionModel;
import com.kytc.service.base.IPremissionService;

@Controller("premissionController")
@RequestMapping("/premission")
public class PremissionController {
	private String ROOT_PATH = "/premission/";
	@Autowired
	private IPremissionService premissionService;
	@RequestMapping(value={"","/index"},method=RequestMethod.GET)
	public String index(){
		return ROOT_PATH+"index";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public PageResult<PremissionModel> list(HttpServletRequest request){
		Map<String,Object> params = CommonUtils.getRequestMap(request);
		return premissionService.list(params);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return ROOT_PATH+"add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(PremissionEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return premissionService.add(entity);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model){
		ResultModel<PremissionEntity> result = premissionService.getById(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> update(PremissionEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return premissionService.update(entity);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(PremissionEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return premissionService.delete(entity);
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Integer id,Model model){
		ResultModel<PremissionModel> result = premissionService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"detail";
	}
	@RequestMapping(value="/addBetch",method=RequestMethod.GET)
	@ResponseBody
	public ResultModel<String> addBetch(String project,String module,String menu,String operator,Model model){
		return premissionService.addBetch(project, module, menu, operator);
	}
	@RequestMapping(value="/premission",method=RequestMethod.GET)
	public String premission(Integer roleId,Model model){
		model.addAttribute("list", premissionService.getPremissions());
		return ROOT_PATH+"premission";
	}
}
