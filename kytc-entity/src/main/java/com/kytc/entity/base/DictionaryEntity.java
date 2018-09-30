package com.kytc.entity.base;

import com.kytc.entity.Entity;

/**
 * @author 何志同
 * @description 数据字典表
 * @date 2017年6月4日下午10:24:02
 * @link_table kytc_base_dictionary
 */
public class DictionaryEntity extends Entity {
	private Integer id;
	private String type;
	private String code;
	private String name;
	private String parentType;
	private String parentCode;
	private Integer sortNum;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentType() {
		return parentType;
	}
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "DictionaryEntity [id=" + id + ", type=" + type + ", code="
				+ code + ", name=" + name + ", parentType=" + parentType
				+ ", parentCode=" + parentCode + ", sortNum=" + sortNum
				+ ", remark=" + remark + ", toString()=" + super.toString()
				+ "]";
	}
}
