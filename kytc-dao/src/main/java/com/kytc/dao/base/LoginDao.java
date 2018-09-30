package com.kytc.dao.base;

import com.kytc.entity.base.LoginEntity;
import com.kytc.model.base.UserLoginModel;

/**
 * @author 何志同
 * @description 登录操作表
 * @date 2017年5月21日上午9:15:26
 * @link_table kytc_base_login
 */
public interface LoginDao {
	/**
	 * @author 何志同
	 * @description 登录获取用户信息
	 * @date 2017年5月21日上午9:15:56
	 * @param entity
	 * @return UserLoginModel
	 */
	public UserLoginModel login(LoginEntity entity);
}
