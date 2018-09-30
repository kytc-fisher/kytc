package com.kytc.model.base;

import com.kytc.entity.base.DepartmentEntity;

public class DepartmentModel extends DepartmentEntity {
	private String parentName;
	private String leaderName;
	private String operatorName;
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	@Override
	public String toString() {
		return "DepartmentModel [parentName=" + parentName + ", leaderName="
				+ leaderName + ", operatorName=" + operatorName
				+ ", toString()=" + super.toString() + "]";
	}
}
