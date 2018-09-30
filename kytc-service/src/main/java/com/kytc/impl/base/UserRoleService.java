package com.kytc.impl.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.UserRoleDao;
import com.kytc.entity.base.UserRoleEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.RoleModel;
import com.kytc.model.base.UserRoleModel;
import com.kytc.service.base.IRoleService;
import com.kytc.service.base.IUserRoleService;
import com.kytc.utils.CommonUtils;
@Service("userRoleService")
public class UserRoleService implements IUserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private IRoleService roleService;
	@Override
	public List<UserRoleModel> list(Integer userId) {
		// TODO Auto-generated method stub
		return userRoleDao.list(userId);
	}

	@Override
	public ResultModel<String> add(UserRoleEntity entity) {
		// TODO Auto-generated method stub
		userRoleDao.add(entity);
		return CommonUtils.returnModel(true, "添加成功");
	}

	@Override
	public ResultModel<String> delete(UserRoleEntity entity) {
		// TODO Auto-generated method stub
		userRoleDao.delete(entity);
		return CommonUtils.returnModel(true, "删除成功");
	}

	@Override
	public Map<String, Object> list(Integer userId, Integer departmentId) {
		// TODO Auto-generated method stub
		List<RoleModel> roleList = roleService.getRoleList(departmentId);
		List<UserRoleModel> list = list(userId);
		if(list!=null && roleList!=null){
			for(RoleModel role:roleList){
				for(UserRoleModel model:list){
					if(role.getId().equals(model.getRoleId())){
						role.setIsSelected(true);
						break;
					}
				}
			}
		}
		System.out.println(list);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("role", roleList);
		map.put("list", list);
		return map;
	}

}
