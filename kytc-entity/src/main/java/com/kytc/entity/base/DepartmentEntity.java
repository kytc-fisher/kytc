package com.kytc.entity.base;

import java.util.Date;

/**
 * @author 何志同
 * @description 部门信息
 * @date 2017年5月20日下午9:51:59
 * @link_table kytc_base_department
 */
public class DepartmentEntity {
	private Integer id;
	private String departmentName;
	private String shortName;
	private String englishName;
	private Date establishTime;
	private String description;
	private Integer parentId;
	private Integer sortNum;
	private Integer leaderId;
	private Date createTime;
	private Date lastUpdateTime;
	private Integer operatorId;
	private Integer isDelete;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public Date getEstablishTime() {
		return establishTime;
	}
	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", departmentName="
				+ departmentName + ", shortName=" + shortName
				+ ", englishName=" + englishName + ", establishTime="
				+ establishTime + ", description=" + description
				+ ", parentId=" + parentId + ", sortNum=" + sortNum
				+ ", leaderId=" + leaderId + ", createTime=" + createTime
				+ ", lastUpdateTime=" + lastUpdateTime + ", operatorId="
				+ operatorId + ", isDelete=" + isDelete + "]";
	}
}
