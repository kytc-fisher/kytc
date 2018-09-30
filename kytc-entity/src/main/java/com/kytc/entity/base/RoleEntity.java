package com.kytc.entity.base;

import com.kytc.entity.Entity;

/**
 * @author 何志同
 * @description 角色表
 * @date 2017年6月4日下午9:35:04
 * @link_table kytc_base_role
 */
public class RoleEntity extends Entity{
	private Integer id;
	private String roleName;
	private Integer departmentId;
	private byte type;
	private String description;
	private Integer sortNum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	@Override
	public String toString() {
		return "RoleEntity [id=" + id + ", roleName=" + roleName
				+ ", departmentId=" + departmentId + ", type=" + type
				+ ", description=" + description + ", sortNum=" + sortNum + "]";
	}
}
