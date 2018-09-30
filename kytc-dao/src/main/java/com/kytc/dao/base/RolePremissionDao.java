package com.kytc.dao.base;

import java.util.List;

import com.kytc.entity.base.RolePremissionEntity;
import com.kytc.model.base.PremissionModel;

public interface RolePremissionDao{
	/**
	 * @author 何志同
	 * @description 角色与权限绑定
	 * @date 2017年6月13日下午11:23:51
	 * @param entity
	 * @return Boolean
	 */
	public Boolean add(RolePremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 解除角色与权限的绑定
	 * @date 2017年6月13日下午11:31:55
	 * @param roleId
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(RolePremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 根据角色ID获取对应的权限
	 * @date 2017年6月13日下午11:30:47
	 * @param roleId
	 * @return List<String>
	 */
	public List<String> getByRoleId(Integer roleId);
	/**
	 * @author 何志同
	 * @description 获取角色绑定的权限信息
	 * @date 2017年6月16日下午10:34:36
	 * @param roleId
	 * @return List<PremissionModel>
	 */
	public List<PremissionModel> getRolePremission(Integer roleId);
}