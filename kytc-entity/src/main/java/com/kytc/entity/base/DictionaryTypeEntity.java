package com.kytc.entity.base;

import com.kytc.entity.Entity;

/**
 * @author 何志同
 * @description 数据字典类型表
 * @date 2017年6月4日下午10:35:00
 * @link_table kytc_base_dictionary_type
 */
public class DictionaryTypeEntity extends Entity {
//	  `id` int(11) NOT NULL,
//	  `code` varchar(255) DEFAULT NULL COMMENT '编码',
//	  `name` varchar(255) DEFAULT NULL COMMENT '名称',
//	  `isDelete` tinyint(4) DEFAULT NULL,
//	  `remark` varchar(255) DEFAULT NULL,
//	  `operatorId` int(11) DEFAULT NULL,
//	  `createTime` timestamp NULL DEFAULT NULL,
//	  `lastUpdateTime` datetime DEFAULT NULL,
//	  `sortNum` int(11) DEFAULT NULL COMMENT '排序号',
	private Integer id;
	private String code;
	private String name;
	private String remark;
	private Integer sortNum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	@Override
	public String toString() {
		return "DictionaryTypeEntity [id=" + id + ", code=" + code + ", name="
				+ name + ", remark=" + remark + ", sortNum=" + sortNum
				+ ", toString()=" + super.toString() + "]";
	}
}
