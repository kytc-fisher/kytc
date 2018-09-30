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
import com.kytc.entity.base.DictionaryEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DictionaryModel;
import com.kytc.service.base.IDictionaryService;

@Controller("dictionaryController")
@RequestMapping("dictionary")
public class DictionaryController {
	private String ROOT_PATH = "/dictionary/";
	@Autowired
	private IDictionaryService dictionaryService;
	@RequestMapping(value={"","/index"},method=RequestMethod.GET)
	public String index(){
		return ROOT_PATH+"index";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public PageResult<DictionaryModel> list(HttpServletRequest request){
		Map<String,Object> params = CommonUtils.getRequestMap(request);
		return dictionaryService.pageResult(params);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return ROOT_PATH+"add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(DictionaryEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return dictionaryService.add(entity);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model){
		ResultModel<DictionaryModel> result = dictionaryService.getById(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> update(DictionaryEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return dictionaryService.update(entity);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(DictionaryEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return dictionaryService.delete(entity);
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Integer id,Model model){
		ResultModel<DictionaryModel> result = dictionaryService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"detail";
	}
	@RequestMapping(value="/dropdown",method=RequestMethod.GET)
	@ResponseBody
	public List<ComboboxModel> dropdown(String parentType,String parentCode,String type){
		System.out.println(parentType+"\n"+parentCode+"\n"+type);
		if(parentType==null||parentType.equals("")){
			return dictionaryService.droplist(type);
		}
		return dictionaryService.droplist(parentType, parentCode, type);
	}
}
