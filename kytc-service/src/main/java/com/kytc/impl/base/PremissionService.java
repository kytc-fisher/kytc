package com.kytc.impl.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.PremissionDao;
import com.kytc.entity.base.PremissionEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.PremissionModel;
import com.kytc.model.base.premission.ProjectModel;
import com.kytc.service.base.IPremissionService;
import com.kytc.utils.CommonUtils;
@Service("premissionService")
public class PremissionService implements IPremissionService {
	@Autowired
	private PremissionDao premissionDao;
	@Override
	public PageResult<PremissionModel> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageResult<PremissionModel> pageResult = new PageResult<PremissionModel>(params);
		pageResult.setRows(premissionDao.list(params));
		pageResult.setTotal(premissionDao.count(params));
		return pageResult;
	}

	@Override
	public ResultModel<String> add(PremissionEntity entity) {
		// TODO Auto-generated method stub
		PremissionEntity en = premissionDao.getByPremission(entity.getPremission());
		if(en==null){
			en = premissionDao.getByParams(entity.getProject(), entity.getModule(), entity.getMenu(), entity.getOperator());
			if(en==null){
				Boolean result = premissionDao.add(entity);
				if(result){
					return CommonUtils.returnModel(true,"添加成功",null);
				}else{
					return CommonUtils.returnModel(false,"添加失败",null);
				}
			}
		}
		if(en!=null && en.getIsDelete()==1){
			entity.setId(en.getId());
			Boolean result = premissionDao.addUpdate(entity);
			if(result){
				return CommonUtils.returnModel(true,"添加成功",null);
			}else{
				return CommonUtils.returnModel(false,"添加失败",null);
			}
		}
		return CommonUtils.returnModel(false,"该权限已经存在,添加失败",null);
	}

	@Override
	public ResultModel<String> update(PremissionEntity entity) {
		// TODO Auto-generated method stub
		PremissionEntity en = premissionDao.getByPremission(entity.getPremission());
		System.out.println(en);
		if(en==null||en.getIsDelete()==1||en.getId().equals(entity.getId())){
			en = premissionDao.getByParams(entity.getProject(), entity.getModule(), entity.getMenu(), entity.getOperator());
			System.out.println(en);
			if(en==null||en.getIsDelete()==1||en.getId().equals(entity.getId())){
				Boolean result = premissionDao.update(entity);
				if(result){
					return CommonUtils.returnModel(true,"添加成功",null);
				}else{
					return CommonUtils.returnModel(false,"添加失败",null);
				}
			}
		}
		return CommonUtils.returnModel(false,"该权限已经存在,修改失败",null);
	}

	@Override
	public ResultModel<String> delete(PremissionEntity entity) {
		// TODO Auto-generated method stub
		Boolean result = premissionDao.delete(entity);
		if(result){
			return CommonUtils.returnModel(true,"删除成功",null);
		}else{
			return CommonUtils.returnModel(false,"删除失败",null);
		}
	}

	@Override
	public ResultModel<PremissionModel> detail(Integer id) {
		// TODO Auto-generated method stub
		return CommonUtils.returnModel(premissionDao.detail(id));
	}

	@Override
	public ResultModel<PremissionEntity> getById(Integer id) {
		// TODO Auto-generated method stub
		return CommonUtils.returnModel(premissionDao.getById(id));
	}

	@Override
	public ResultModel<String> addBetch(String project, String module,
			String menu, String operator) {
		// TODO Auto-generated method stub
		for(String oper:operator.split(",")){
			PremissionEntity entity = new PremissionEntity();
			entity.setProject("KYTC_"+project.toUpperCase());
			entity.setModule("KYTC_MODULE_"+module.toUpperCase());
			entity.setMenu("KYTC_MENU_"+menu.toUpperCase());
			if(oper.equals("edit")){
				entity.setOperator("KYTC_OPERATOR_UPDATE");
			}else{
				entity.setOperator("KYTC_OPERATOR_"+oper.toUpperCase());
			}
			entity.setPremission("kytc:"+project+":"+module+":"+menu+":"+oper);
			entity.setOperatorId(1);
			premissionDao.add(entity);
		}
		return CommonUtils.returnModel(true,"添加成功",null);
	}

	@Override
	public List<ProjectModel> getPremissions() {
		// TODO Auto-generated method stub
		List<PremissionModel> list = premissionDao.getPremissions();
		return CommonUtils.initPremission(list);
	}
}
