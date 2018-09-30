package com.kytc.model.base;

import com.kytc.entity.base.PremissionEntity;

public class PremissionModel extends PremissionEntity {
	private String operatorName;
	private String operateName;
	private String projectName;
	private String moduleName;
	private String menuName;
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
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
		return "PremissionModel [operatorName=" + operatorName
				+ ", operateName=" + operateName + ", projectName="
				+ projectName + ", moduleName=" + moduleName + ", menuName="
				+ menuName + ", toString()=" + super.toString() + "]";
	}
}
