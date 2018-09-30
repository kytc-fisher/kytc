package com.kytc.impl.base;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.UserDao;
import com.kytc.entity.base.UserEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.UserModel;
import com.kytc.service.base.IUserService;
import com.kytc.utils.CommonUtils;
@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private UserDao userDao;
	@Override
	public PageResult<UserModel> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageResult<UserModel> page = new PageResult<UserModel>(params);
		page.setTotal(userDao.count(params));
		page.setRows(userDao.list(params));
		return page;
	}
	@Override
	public ResultModel<Object> add(UserEntity entity) {
		// TODO Auto-generated method stub
		Boolean flag = userDao.add(entity);
		if(flag){
			return CommonUtils.returnModel(true, "", null);
		}
		return CommonUtils.returnModel(false,"添加失败");
	}
	@Override
	public ResultModel<Object> update(UserEntity entity) {
		// TODO Auto-generated method stub
		Boolean result = userDao.update(entity);
		if(result){
			return CommonUtils.returnModel(true, "");
		}
		return CommonUtils.returnModel(false,"修改失败");
	}
	@Override
	public ResultModel<Object> delete(UserEntity entity) {
		// TODO Auto-generated method stub
		Boolean result = userDao.delete(entity);
		if(result){
			return CommonUtils.returnModel(true, "");
		}
		return CommonUtils.returnModel(false,"删除失败");
	}
	@Override
	public ResultModel<UserModel> detail(Integer id) {
		// TODO Auto-generated method stub
		UserModel model = userDao.detail(id);
		if(model!=null){
			return CommonUtils.returnModel(model);
		}
		return CommonUtils.returnModel(false,"该用户不存在,请刷新页面");
	}
	@Override
	public ResultModel<UserEntity> getById(Integer id) {
		// TODO Auto-generated method stub
		return CommonUtils.returnModel(userDao.getById(id));
	}
}
