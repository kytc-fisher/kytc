package com.kytc.service.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.UserRoleEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.UserRoleModel;

public interface IUserRoleService{
	/**
	 * @author 何志同
	 * @description 获取用户角色列表
	 * @date 2017年6月17日下午9:54:15
	 * @param userId 用户ID
	 * @return List<UserRoleModel>
	 */
	public List<UserRoleModel> list(Integer userId);
	/**
	 * @author 何志同
	 * @description 用户设置的角色列表
	 * @date 2017年6月18日下午7:05:10
	 * @param userId
	 * @param departmentId
	 * @return Map<String,List<UserRoleModel>>
	 */
	public Map<String,Object> list(Integer userId,Integer departmentId);
	/**
	 * @author 何志同
	 * @description 绑定用户角色
	 * @date 2017年6月17日下午9:58:00
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(UserRoleEntity entity);
	/**
	 * @author 何志同
	 * @description 解除用户与角色的绑定
	 * @date 2017年6月17日下午9:58:16
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(UserRoleEntity entity);
}