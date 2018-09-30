package com.kytc.model.base;

import com.kytc.entity.base.DictionaryTypeEntity;

public class DictionaryTypeModel extends DictionaryTypeEntity {
	private String operatorName;
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	@Override
	public String toString() {
		return "DictionaryTypeModel [operatorName=" + operatorName
				+ ", toString()=" + super.toString() + "]";
	}
}
