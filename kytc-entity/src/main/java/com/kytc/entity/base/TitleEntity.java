package com.kytc.entity.base;

import java.util.Date;

/**
 * @author 何志同
 * @description 
 * @date 2017年5月29日上午8:57:35
 * @link_table kytc_base_title
 */
public class TitleEntity {
	private Integer id;
	private String name;
	private Integer sortNum;
	private Integer parentId;
	private Integer isDelete;
	private String remark;
	private Date createTime;
	private Integer operatorId;
	private Date lastUpdateTime;
	@Override
	public String toString() {
		return "TitleEntity [id=" + id + ", name=" + name + ", sortNum="
				+ sortNum + ", parentId=" + parentId + ", isDelete=" + isDelete
				+ ", remark=" + remark + ", createTime=" + createTime
				+ ", operatorId=" + operatorId + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
