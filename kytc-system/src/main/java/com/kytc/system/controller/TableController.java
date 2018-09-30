package com.kytc.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kytc.model.ResultModel;
import com.kytc.service.base.ITableService;

@Controller("tableController")
@RequestMapping("/table")
public class TableController {
	@Autowired
	private ITableService tableService;
	@RequestMapping(value="/export",method=RequestMethod.GET)
	@ResponseBody
	public ResultModel<String> export(String tableName){
		return tableService.toFile(tableName, "kytc");
	}
}
