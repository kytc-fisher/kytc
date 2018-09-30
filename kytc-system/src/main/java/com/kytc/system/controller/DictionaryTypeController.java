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
import com.kytc.entity.base.DictionaryTypeEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DictionaryTypeModel;
import com.kytc.service.base.IDictionaryTypeService;

@Controller("dictionaryTypeController")
@RequestMapping("dictionaryType")
public class DictionaryTypeController {
	private String ROOT_PATH = "/dictionaryType/";
	@Autowired
	private IDictionaryTypeService dictionaryTypeService;
	@RequestMapping(value={"","/index"},method=RequestMethod.GET)
	public String index(){
		return ROOT_PATH+"index";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public PageResult<DictionaryTypeEntity> list(HttpServletRequest request){
		Map<String,Object> params = CommonUtils.getRequestMap(request);
		return dictionaryTypeService.pageResult(params);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return ROOT_PATH+"add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(DictionaryTypeEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return dictionaryTypeService.add(entity);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model){
		ResultModel<DictionaryTypeEntity> result = dictionaryTypeService.getById(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> update(DictionaryTypeEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return dictionaryTypeService.update(entity);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(DictionaryTypeEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return dictionaryTypeService.delete(entity);
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Integer id,Model model){
		ResultModel<DictionaryTypeModel> result = dictionaryTypeService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"detail";
	}
	@RequestMapping(value="/dropdown",method=RequestMethod.GET)
	@ResponseBody
	public List<ComboboxModel> dropdown(){
		return dictionaryTypeService.droplist();
	}
}
