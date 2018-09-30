package com.kytc.model.base;

import com.kytc.entity.base.UserEntity;

/**
 * @author 何志同
 * @description 用户模型数据(包含部门名称)
 * @date 2017年5月20日下午11:01:16
 */
public class UserModel extends UserEntity {
	private String departmentName;               //部门名称
	private String shortName;                    //部门简称
	private String operatorName;                 //最后操作人名字
	private String titleName;                    //职位名称
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	@Override
	public String toString() {
		return "UserModel [departmentName=" + departmentName + ", shortName="
				+ shortName + ", operatorName=" + operatorName + ", titleName="
				+ titleName + ", toString()=" + super.toString() + "]";
	}
	public static void main(String[] args) {
		UserModel model = new UserModel();
		model.setNickName("i伤心鱼");
		model.setDepartmentName("IT部门");
		System.out.println(model);
	}
}
