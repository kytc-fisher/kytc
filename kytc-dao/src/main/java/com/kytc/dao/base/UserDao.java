package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.UserEntity;
import com.kytc.model.base.UserModel;

/**
 * @author 何志同
 * @description 用户信息的操作
 * @date 2017年5月20日下午10:12:35
 * @link_table kytc_base_user
 */
public interface UserDao {
	/**
	 * @author 何志同
	 * @description 添加用户信息
	 * @date 2017年5月20日下午10:13:44
	 * @param entity
	 * @return Integer
	 */
	public Boolean add(UserEntity entity);
	/**
	 * @author 何志同
	 * @description 修改用户信息
	 * @date 2017年5月20日下午10:13:58
	 * @param entity
	 * @return Integer
	 */
	public Boolean update(UserEntity entity);
	/**
	 * @author 何志同
	 * @description 删除用户信息
	 * @date 2017年5月20日下午10:14:33
	 * @param entity
	 * @return Integer
	 */
	public Boolean delete(UserEntity entity);
	/**
	 * @author 何志同
	 * @description 获取用户信息数量
	 * @date 2017年5月20日下午10:14:50
	 * @param params
	 * @return Integer
	 */
	public Integer count(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 获取用户信息列表
	 * @date 2017年5月20日下午10:15:05
	 * @param params
	 * @return List<UserEntity>
	 */
	public List<UserModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 查看用户的详细信息
	 * @date 2017年5月20日下午11:10:01
	 * @param id
	 * @return UserModel
	 */
	public UserModel detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取用户基本信息
	 * @date 2017年5月30日下午10:30:29
	 * @param id
	 * @return UserEntity
	 */
	public UserEntity getById(Integer id);
}
