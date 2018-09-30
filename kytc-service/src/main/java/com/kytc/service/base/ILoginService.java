package com.kytc.service.base;

import com.kytc.entity.base.LoginEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.UserLoginModel;

/**
 * @author 何志同
 * @description 登录模块service层
 * @date 2017年5月21日上午9:46:09
 */
public interface ILoginService {
	/**
	 * @author 何志同
	 * @description 用户登录
	 * @date 2017年5月21日上午9:46:23
	 * @param entity
	 * @return ResultModel<UserLoginModel> 返回登录结果集
	 */
	public ResultModel<UserLoginModel> login(LoginEntity entity);
}
