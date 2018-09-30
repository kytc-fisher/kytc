package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kytc.entity.base.UserPremissionEntity;

public interface UserPremissionDao{
	/**
	 * @author 何志同
	 * @description 获取用户权限
	 * @date 2017年6月17日下午7:21:13
	 * @param userId 用户ID
	 * @return List<String>
	 */
	public List<String> list(Integer userId);
	/**
	 * @author 何志同
	 * @description 添加用户权限
	 * @date 2017年6月17日下午7:21:56
	 * @param entity 添加用户权限
	 * @return Boolean
	 */
	public Boolean add(UserPremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 删除用户权限
	 * @date 2017年6月17日下午7:23:37
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(UserPremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 获取用户的所有权限
	 * @date 2017年6月20日下午11:36:38
	 * @param min
	 * @param pageSize
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> getAllUserPremissions(@Param("min")Integer min,@Param("pageSize")Integer pageSize);
}