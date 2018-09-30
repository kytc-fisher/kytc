package com.kytc.entity.base;

public class UserRoleEntity{
	private Integer id;                     //键：PRI
	private Integer userId;                 //用户id;
	private Integer roleId;                 //id;
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return this.userId;
	}
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	public Integer getRoleId(){
		return this.roleId;
	}
	@Override
	public String toString(){
		return "UserRoleEntity [id = "+id + 
			",userId = "+userId + 
			",roleId = "+roleId + 
		"]";
	}
}