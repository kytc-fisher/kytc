package com.kytc.model.base;

import com.kytc.entity.base.TitleEntity;

public class TitleModel extends TitleEntity {
	private String operatorName;
	private String parentName;
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	@Override
	public String toString() {
		return "TitleModel [operatorName=" + operatorName + ", parentName="
				+ parentName + ", toString()=" + super.toString() + "]";
	}
}
