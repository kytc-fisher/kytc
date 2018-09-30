package com.kytc.impl.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.RolePremissionDao;
import com.kytc.entity.base.RolePremissionEntity;
import com.kytc.model.ResultModel;
import com.kytc.model.base.PremissionModel;
import com.kytc.model.base.premission.ProjectModel;
import com.kytc.service.base.IPremissionService;
import com.kytc.service.base.IRolePremissionService;
import com.kytc.utils.CommonUtils;

@Service("rolePremissionService")
public class RolePremissionService implements IRolePremissionService{
	@Autowired
	private IPremissionService premissionService;
	@Autowired
	private RolePremissionDao rolePremissionDao;
	@Override
	public ResultModel<String> add(RolePremissionEntity entity){
		rolePremissionDao.add(entity);
		return CommonUtils.returnModel(true,"添加成功",null);
	}
	@Override
	public ResultModel<String> delete(RolePremissionEntity entity){
		rolePremissionDao.delete(entity);
		return CommonUtils.returnModel(true,"删除成功",null);
	}
	@Override
	public List<String> getByRoleId(Integer id){
		return rolePremissionDao.getByRoleId(id);
	}
	@Override
	public List<ProjectModel> getPremissions(Integer roleId) {
		// TODO Auto-generated method stub
		List<String> list = rolePremissionDao.getByRoleId(roleId);
		List<ProjectModel> projectList = premissionService.getPremissions();
		return CommonUtils.selectPremission(projectList, list);
	}
	@Override
	public List<ProjectModel> getRolePremission(Integer roleId){
		List<PremissionModel> list = rolePremissionDao.getRolePremission(roleId);
		return CommonUtils.initPremission(list);
	}
}