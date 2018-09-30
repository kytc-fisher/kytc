package com.kytc.impl.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.RoleDao;
import com.kytc.entity.base.RoleEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.RoleModel;
import com.kytc.service.base.IRolePremissionService;
import com.kytc.service.base.IRoleService;
import com.kytc.utils.CommonUtils;

@Service("roleService")
public class RoleService implements IRoleService{
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private IRolePremissionService rolePremissionService;
	@Override
	public PageResult<RoleModel> list(Map<String,Object> params){
		PageResult<RoleModel> pageResult = new PageResult<RoleModel>(params);
		List<RoleModel> list = roleDao.list(params);
		Integer count = roleDao.count(params);
		pageResult.setRows(list);
		pageResult.setTotal(count);
		return pageResult;
	}
	@Override
	public ResultModel<String> add(RoleEntity entity){
		RoleEntity en = roleDao.getByRoleName(entity.getRoleName(), entity.getDepartmentId());
		if(en==null){
			Boolean result = roleDao.add(entity);
			if(result){
				return CommonUtils.returnModel(true,"添加成功",null);
			}else{
				return CommonUtils.returnModel(false,"添加失败",null);
			}
		}else if(en.getIsDelete()==1){
			entity.setId(en.getId());
			Boolean result = roleDao.addUpdate(entity);
			if(result){
				return CommonUtils.returnModel(true,"添加成功",null);
			}else{
				return CommonUtils.returnModel(false,"添加失败",null);
			}
		}else{
			return CommonUtils.returnModel(false,"该角色已经存在,添加失败",null);
		}
	}
	@Override
	public ResultModel<String> update(RoleEntity entity){
		RoleEntity en = roleDao.getByRoleName(entity.getRoleName(), entity.getDepartmentId());
		if(en==null||en.getIsDelete()==1||en.getId().equals(entity.getId())){
			Boolean result = roleDao.update(entity);
			if(result){
				return CommonUtils.returnModel(true,"修改成功",null);
			}else{
				return CommonUtils.returnModel(false,"修改失败",null);
			}
		}else{
			return CommonUtils.returnModel(false,"该角色名称已经存在,修改失败",null);
		}
	}
	@Override
	public ResultModel<String> delete(RoleEntity entity){
		Boolean result = roleDao.delete(entity);
		if(result){
			return CommonUtils.returnModel(true,"删除成功",null);
		}else{
			return CommonUtils.returnModel(false,"删除失败",null);
		}
	}
	@Override
	public ResultModel<RoleModel> detail(Integer id){
		RoleModel model = roleDao.detail(id);
		System.out.println(id);
		System.out.println(rolePremissionService.getRolePremission(id));
		model.setList(rolePremissionService.getRolePremission(id));
		return CommonUtils.returnModel(model);
	}
	@Override
	public ResultModel<RoleEntity> getById(Integer id) {
		// TODO Auto-generated method stub
		return CommonUtils.returnModel(roleDao.getById(id));
	}
	@Override
	public List<RoleModel> getRoleList(Integer departmentId) {
		// TODO Auto-generated method stub
		return roleDao.getRoleList(departmentId);
	}
}