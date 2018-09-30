package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kytc.entity.base.RoleEntity;
import com.kytc.model.base.RoleModel;

public interface RoleDao{
	/**
	 * @author 何志同
	 * @description 获取数据源
	 * @date 2017年6月10日下午7:45:55
	 * @param params
	 * @return List<RoleEntity>
	 */
	public List<RoleModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 获取条数
	 * @date 2017年6月10日下午7:46:07
	 * @param params
	 * @return Integer
	 */
	public Integer count(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加角色
	 * @date 2017年6月10日下午7:46:19
	 * @param entity
	 * @return Boolean
	 */
	public Boolean add(RoleEntity entity);
	/**
	 * @author 何志同
	 * @description 修改角色
	 * @date 2017年6月10日下午7:46:33
	 * @param entity
	 * @return Boolean
	 */
	public Boolean update(RoleEntity entity);
	/**
	 * @author 何志同
	 * @description 删除角色
	 * @date 2017年6月10日下午7:46:45
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(RoleEntity entity);
	/**
	 * @author 何志同
	 * @description 获取角色详情
	 * @date 2017年6月10日下午7:46:56
	 * @param id
	 * @return RoleModel
	 */
	public RoleModel detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取角色信息
	 * @date 2017年6月10日下午7:47:11
	 * @param id
	 * @return RoleEntity
	 */
	public RoleEntity getById(Integer id);
	/**
	 * @author 何志同
	 * @description 添加已经删除的角色信息
	 * @date 2017年6月10日下午7:47:25
	 * @param entity
	 * @return Boolean
	 */
	public Boolean addUpdate(RoleEntity entity);
	/**
	 * @author 何志同
	 * @description 根据角色名称和部门ID获取信息
	 * @date 2017年6月10日下午8:28:03
	 * @param roleName
	 * @param departmentId
	 * @return RoleEntity
	 */
	public RoleEntity getByRoleName(@Param("roleName")String roleName,@Param("departmentId") Integer departmentId);
	/**
	 * @author 何志同
	 * @description 获取角色列表
	 * @date 2017年6月17日上午9:03:44
	 * @param departmentId
	 * @return List<RoleEntity>
	 */
	public List<RoleModel> getRoleList(@Param("departmentId") Integer departmentId);
}