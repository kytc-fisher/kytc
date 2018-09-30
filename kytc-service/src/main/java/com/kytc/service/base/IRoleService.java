package com.kytc.service.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.RoleEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.RoleModel;

public interface IRoleService{
	/**
	 * @author 何志同
	 * @description 分页数据源
	 * @date 2017年6月10日下午8:20:53
	 * @param params
	 * @return PageResult<RoleModel>
	 */
	public PageResult<RoleModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加角色
	 * @date 2017年6月10日下午8:21:05
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(RoleEntity entity);
	/**
	 * @author 何志同
	 * @description 修改角色
	 * @date 2017年6月10日下午8:21:19
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> update(RoleEntity entity);
	/**
	 * @author 何志同
	 * @description 删除角色
	 * @date 2017年6月10日下午8:21:32
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(RoleEntity entity);
	/**
	 * @author 何志同
	 * @description 查看角色详情
	 * @date 2017年6月10日下午8:21:54
	 * @param id
	 * @return ResultModel<RoleModel>
	 */
	public ResultModel<RoleModel> detail(Integer id);
	/**
	 * @author 何志同
	 * @description 查看角色
	 * @date 2017年6月10日下午8:22:11
	 * @param id
	 * @return ResultModel<RoleEntity>
	 */
	public ResultModel<RoleEntity> getById(Integer id);
	/**
	 * @author 何志同
	 * @description 获取部门角色列表
	 * @date 2017年6月17日上午9:08:50
	 * @param departmentId
	 * @return List<RoleModel>
	 */
	public List<RoleModel> getRoleList(Integer departmentId);
}