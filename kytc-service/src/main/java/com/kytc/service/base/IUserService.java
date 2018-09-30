package com.kytc.service.base;

import java.util.Map;

import com.kytc.entity.base.UserEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.UserModel;

/**
 * @author 何志同
 * @description 用户的操作
 * @date 2017年5月21日下午8:04:57
 */
public interface IUserService {
	/**
	 * @author 何志同
	 * @description 获取用户的分页数据
	 * @date 2017年5月21日下午8:04:42
	 * @param params
	 * @return PageResult<UserModel>
	 */
	public PageResult<UserModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加用户基础数据
	 * @date 2017年5月21日下午8:05:16
	 * @param entity
	 * @return ResultModel<Object>
	 */
	public ResultModel<Object> add(UserEntity entity);
	/**
	 * @author 何志同
	 * @description 更新用户基础数据
	 * @date 2017年5月21日下午8:05:32
	 * @param entity
	 * @return ResultModel<Object>
	 */
	public ResultModel<Object> update(UserEntity entity);
	/**
	 * @author 何志同
	 * @description 删除用户数据
	 * @date 2017年5月21日下午8:05:48
	 * @param entity
	 * @return ResultModel<Object>
	 */
	public ResultModel<Object> delete(UserEntity entity);
	/**
	 * @author 何志同
	 * @description 查看用户详情
	 * @date 2017年5月21日下午8:06:32
	 * @param id
	 * @return ResultModel<UserModel>
	 */
	public ResultModel<UserModel> detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取用户基本信息
	 * @date 2017年5月30日下午10:32:17
	 * @param id
	 * @return ResultModel<UserEntity>
	 */
	public ResultModel<UserEntity> getById(Integer id); 
}
