package com.kytc.entity;

import java.util.Date;

public class Entity {
	private Integer operatorId;
	private Date createTime;
	private Date lastUpdateTime;
	private byte isDelete;
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
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
	public byte getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Entity [operatorId=" + operatorId + ", createTime="
				+ createTime + ", lastUpdateTime=" + lastUpdateTime
				+ ", isDelete=" + isDelete + "]";
	}
}
