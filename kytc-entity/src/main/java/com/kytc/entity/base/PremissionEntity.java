package com.kytc.entity.base;

import com.kytc.entity.Entity;

public class PremissionEntity extends Entity{
	private Integer id;                     //键：PRI
	private String project;                 //项目;
	private String module;                  //模块;
	private String menu;                    //菜单;
	private String operator;                //操作;
	private String premission;              //权限;
	private String description;             //描述;
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setProject(String project){
		this.project = project;
	}
	public String getProject(){
		return this.project;
	}
	public void setModule(String module){
		this.module = module;
	}
	public String getModule(){
		return this.module;
	}
	public void setMenu(String menu){
		this.menu = menu;
	}
	public String getMenu(){
		return this.menu;
	}
	public void setOperator(String operator){
		this.operator = operator;
	}
	public String getOperator(){
		return this.operator;
	}
	public void setPremission(String premission){
		this.premission = premission;
	}
	public String getPremission(){
		return this.premission;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
	@Override
	public String toString() {
		return "PremissionEntity [id=" + id + ", project=" + project
				+ ", module=" + module + ", menu=" + menu + ", operator="
				+ operator + ", premission=" + premission + ", description="
				+ description + ", toString()=" + super.toString() + "]";
	}
}