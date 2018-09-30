package com.kytc.model.base.premission;

public class OperatorModel {
	private String operator;
	private String operateName;
	private String premission;
	private Boolean isSelected = false;
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
	public String getPremission() {
		return premission;
	}
	public void setPremission(String premission) {
		this.premission = premission;
	}
	public Boolean getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	@Override
	public String toString() {
		return "OperatorModel [operator=" + operator + ", operateName="
				+ operateName + ", premission=" + premission + ", isSelected="
				+ isSelected + "]";
	}
	public OperatorModel(String operator, String operateName,
			String premission, Boolean isSelected) {
		super();
		this.operator = operator;
		this.operateName = operateName;
		this.premission = premission;
		this.isSelected = isSelected;
	}
	public OperatorModel(String operator, String operateName, String premission) {
		super();
		this.operator = operator;
		this.operateName = operateName;
		this.premission = premission;
	}
	public OperatorModel() {
		super();
	}
}
