package com.kytc.service.base;

import java.util.List;

import com.kytc.entity.base.RolePremissionEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.premission.ProjectModel;

public interface IRolePremissionService{
	/**
	 * @author 何志同
	 * @description 绑定
	 * @date 2017年6月13日下午11:35:41
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(RolePremissionEntity entity);
	
	/**
	 * @author 何志同
	 * @description 解除绑定
	 * @date 2017年6月13日下午11:35:48
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(RolePremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 根据角色ID获取权限
	 * @date 2017年6月13日下午11:36:09
	 * @param id
	 * @return List<String>
	 */
	public List<String> getByRoleId(Integer id);
	/**
	 * @author 何志同
	 * @description 获取权限列表
	 * @date 2017年6月11日下午8:16:50
	 * @param roleId
	 * @return List<Map<String,Object>>
	 */
	public List<ProjectModel> getPremissions(Integer roleId);
	/**
	 * @author 何志同
	 * @description 根据角色ID获取权限信息
	 * @date 2017年6月16日下午10:48:20
	 * @param roleId
	 * @return List<ProjectModel>
	 */
	public List<ProjectModel> getRolePremission(Integer roleId);
}