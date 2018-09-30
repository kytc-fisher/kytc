package com.kytc.system.controller;

import java.util.List;
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
import com.kytc.entity.base.DepartmentEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DepartmentModel;
import com.kytc.service.base.IDepartmentService;

@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {
	private String ROOT_PATH = "/department/";
	@Autowired
	private IDepartmentService departmentService;
	@RequestMapping(value={"","/index"},method=RequestMethod.GET)
	public String index(){
		return ROOT_PATH+"index";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public PageResult<DepartmentModel> list(HttpServletRequest request){
		Map<String,Object> params = CommonUtils.getRequestMap(request);
		return departmentService.list(params);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return ROOT_PATH+"add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(DepartmentEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return departmentService.add(entity);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model){
		ResultModel<DepartmentModel> result = departmentService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> update(DepartmentEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return departmentService.update(entity);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(DepartmentEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return departmentService.delete(entity);
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Integer id,Model model){
		ResultModel<DepartmentModel> result = departmentService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"detail";
	}
	@RequestMapping(value="/dropdown",method=RequestMethod.GET)
	@ResponseBody
	public List<ComboboxModel> dropdown(){
		return departmentService.droplist();
	}
}
