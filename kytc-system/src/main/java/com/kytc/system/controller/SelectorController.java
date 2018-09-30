package com.kytc.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("selectorController")
@RequestMapping("/selector")
public class SelectorController {
	private String ROOT_PATH = "/selector/";
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String user(){
		return ROOT_PATH+"user";
	}
	@RequestMapping(value="/role",method=RequestMethod.GET)
	public String role(){
		return ROOT_PATH+"role";
	}
}
