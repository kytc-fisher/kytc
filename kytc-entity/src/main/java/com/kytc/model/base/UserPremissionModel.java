package com.kytc.model.base;

import com.kytc.entity.base.UserPremissionEntity;

public class UserPremissionModel extends UserPremissionEntity {
	private String project;                 //项目;
	private String module;                  //模块;
	private String menu;                    //菜单;
	private String operator;                //操作;
	private String operateName;
	private String projectName;
	private String moduleName;
	private String menuName;
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		return "UserPremissionModel [project=" + project + ", module=" + module
				+ ", menu=" + menu + ", operator=" + operator
				+ ", operateName=" + operateName + ", projectName="
				+ projectName + ", moduleName=" + moduleName + ", menuName="
				+ menuName + ", toString()=" + super.toString() + "]";
	}
}
