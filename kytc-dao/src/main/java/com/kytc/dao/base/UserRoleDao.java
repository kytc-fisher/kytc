package com.kytc.dao.base;

import java.util.List;

import com.kytc.entity.base.UserRoleEntity;
import com.kytc.model.base.UserRoleModel;

public interface UserRoleDao{
	/**
	 * @author 何志同
	 * @description 根据用户ID获取选中的角色列表
	 * @date 2017年6月17日上午9:27:22
	 * @param userId
	 * @return List<UserRoleModel>
	 */
	public List<UserRoleModel> list(Integer userId);
	/**
	 * @author 何志同
	 * @description 
	 * @date 2017年6月17日下午6:46:50
	 * @param entity 
	 * @return Boolean
	 */
	public Boolean add(UserRoleEntity entity);
	/**
	 * @author 何志同
	 * @description 删除用户绑定的角色
	 * @date 2017年6月17日下午6:47:42
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(UserRoleEntity entity);
}