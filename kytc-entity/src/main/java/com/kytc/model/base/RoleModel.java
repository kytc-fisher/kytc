package com.kytc.model.base;

import java.util.List;

import com.kytc.entity.base.RoleEntity;
import com.kytc.model.base.premission.ProjectModel;

public class RoleModel extends RoleEntity{
	private String departmentName;
	private String operatorName;
	private List<ProjectModel> list;
	private Boolean isSelected;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public List<ProjectModel> getList() {
		return list;
	}
	public void setList(List<ProjectModel> list) {
		this.list = list;
	}
	public Boolean getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	@Override
	public String toString() {
		return "RoleModel [departmentName=" + departmentName
				+ ", operatorName=" + operatorName + ", list=" + list
				+ ", isSelected=" + isSelected + ", toString()="
				+ super.toString() + "]";
	}
}
