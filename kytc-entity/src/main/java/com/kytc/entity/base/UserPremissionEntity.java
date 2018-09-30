package com.kytc.entity.base;

public class UserPremissionEntity{
	private Integer id;                     //键：PRI
	private Integer userId;                 //
	private String premission;              //
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
	public void setPremission(String premission){
		this.premission = premission;
	}
	public String getPremission(){
		return this.premission;
	}
	@Override
	public String toString(){
		return "UserPremissionEntity [id = "+id + 
			",userId = "+userId + 
			",premission = "+premission + 
		"]";
	}
}