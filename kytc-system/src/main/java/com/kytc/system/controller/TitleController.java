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
import com.kytc.entity.base.TitleEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.TitleModel;
import com.kytc.service.base.ITitleService;

@Controller("titleController")
@RequestMapping("/title")
public class TitleController {
	private String ROOT_PATH = "/title/";
	@Autowired
	private ITitleService titleService;
	@RequestMapping(value={"","/index"},method=RequestMethod.GET)
	public String index(){
		return ROOT_PATH+"index";
	}
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public PageResult<TitleModel> list(HttpServletRequest request){
		Map<String,Object> params = CommonUtils.getRequestMap(request);
		System.out.println(titleService.list(params));
		return titleService.list(params);
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return ROOT_PATH+"add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> add(TitleEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return titleService.add(entity);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model){
		ResultModel<TitleModel> result = titleService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"update";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> update(TitleEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return titleService.update(entity);
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public ResultModel<String> delete(TitleEntity entity){
		entity.setOperatorId(SessionUtils.getUserId());
		return titleService.delete(entity);
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Integer id,Model model){
		ResultModel<TitleModel> result = titleService.detail(id);
		model.addAttribute("result", result);
		return ROOT_PATH+"detail";
	}
	@RequestMapping(value="/dropdown",method=RequestMethod.GET)
	@ResponseBody
	public List<ComboboxModel> dropdown(){
		return titleService.droplist();
	}
}
