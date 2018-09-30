package com.kytc.entity.base;

import java.util.Date;

/**
 * @author 何志同
 * @description 用户的基本信息表
 * @date 2017年5月20日下午9:43:23
 * @link_table kytc_base_user
 */
public class UserEntity {
	private Integer id;                    //主键
	private String nickName;               //用户昵称
	private String realName;               //真实名字
	private String headPicture;            //用户名字
	private Date birthday;                 //出生日期
	private byte sex;                      //性别
	private Integer departmentId;          //所属部门
	private Integer titleId;
	private byte isDelete;                 //是否删除
	private Date createTime;               //创建时间
	private Date lastUpdateTime;           //最后更新时间
	private Integer operatorId;            //操作人ID
	private String email;
	private String phone;
	private String idCard;
	private String remark;
	private String personalSign;
	private Integer isLogin;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getHeadPicture() {
		return headPicture;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public byte getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPersonalSign() {
		return personalSign;
	}
	public void setPersonalSign(String personalSign) {
		this.personalSign = personalSign;
	}
	public Integer getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", nickName=" + nickName
				+ ", realName=" + realName + ", headPicture=" + headPicture
				+ ", birthday=" + birthday + ", sex=" + sex + ", departmentId="
				+ departmentId + ", titleId=" + titleId + ", isDelete="
				+ isDelete + ", createTime=" + createTime + ", lastUpdateTime="
				+ lastUpdateTime + ", operatorId=" + operatorId + ", email="
				+ email + ", phone=" + phone + ", idCard=" + idCard
				+ ", remark=" + remark + ", personalSign=" + personalSign
				+ ", isLogin=" + isLogin + "]";
	}
}
