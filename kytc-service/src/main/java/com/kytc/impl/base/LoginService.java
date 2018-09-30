package com.kytc.impl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.LoginDao;
import com.kytc.entity.base.LoginEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.UserLoginModel;
import com.kytc.service.base.ILoginService;
import com.kytc.utils.CommonUtils;
@Service("loginService")
public class LoginService implements ILoginService {
	@Autowired
	private LoginDao loginDao;
	@Override
	public ResultModel<UserLoginModel> login(LoginEntity entity) {
		// TODO Auto-generated method stub
		UserLoginModel model = loginDao.login(entity);
		if(model!=null){
			if(model.getPassword().equals(entity.getPassword())){
				return CommonUtils.returnModel(model);
			}else{
				return CommonUtils.returnModel("密码错误,登录失败");
			}
		}else{
			return CommonUtils.returnModel("该登录名不存在,登录失败");
		}
	}

}
