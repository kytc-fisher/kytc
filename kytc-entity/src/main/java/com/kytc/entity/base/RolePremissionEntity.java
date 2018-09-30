package com.kytc.entity.base;

public class RolePremissionEntity{
	private Integer id;                 //键：PRI
	private Integer roleId;                 //
	private String premission;                 //
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	public Integer getRoleId(){
		return this.roleId;
	}
	public String getPremission() {
		return premission;
	}
	public void setPremission(String premission) {
		this.premission = premission;
	}
	@Override
	public String toString() {
		return "RolePremissionEntity [id=" + id + ", roleId=" + roleId
				+ ", premission=" + premission + "]";
	}
}