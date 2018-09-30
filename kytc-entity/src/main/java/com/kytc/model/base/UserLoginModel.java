package com.kytc.model.base;

import com.kytc.entity.base.UserEntity;

public class UserLoginModel extends UserEntity {
	private String userName;            //登录用户名
	private String password;            //登录密码
	private byte type;                  //类型 1 userName  2手机号  3邮箱
	private Integer userId;             //关联的用户ID
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserLoginModel [userName=" + userName
				+ ", password=" + password + ", type=" + type + ", userId="
				+ userId + ", toString()=" + super.toString() + "]";
	}
}
