package com.kytc.model.base;

import com.kytc.entity.base.UserRoleEntity;

public class UserRoleModel extends UserRoleEntity {
	private String roleName;
	private Boolean isSelected;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Boolean getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	@Override
	public String toString() {
		return "UserRoleModel [roleName=" + roleName + ", isSelected="
				+ isSelected + ", toString()=" + super.toString() + "]";
	}
}
