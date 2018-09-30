package com.kytc.model.base;

import com.kytc.entity.base.DictionaryEntity;

public class DictionaryModel extends DictionaryEntity {
	private String operatorName;
	private String typeName;
	private String parentCodeName;
	private String parentTypeName;
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getParentCodeName() {
		return parentCodeName;
	}
	public void setParentCodeName(String parentCodeName) {
		this.parentCodeName = parentCodeName;
	}
	public String getParentTypeName() {
		return parentTypeName;
	}
	public void setParentTypeName(String parentTypeName) {
		this.parentTypeName = parentTypeName;
	}
	@Override
	public String toString() {
		return "DictionaryModel [operatorName=" + operatorName + ", typeName="
				+ typeName + ", parentCodeName=" + parentCodeName
				+ ", parentTypeName=" + parentTypeName + ", toString()="
				+ super.toString() + "]";
	}
}
