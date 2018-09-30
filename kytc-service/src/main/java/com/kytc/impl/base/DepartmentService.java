package com.kytc.impl.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.DepartmentDao;
import com.kytc.entity.base.DepartmentEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DepartmentModel;
import com.kytc.service.base.IDepartmentService;
import com.kytc.utils.CommonUtils;
@Service("departmentService")
public class DepartmentService implements IDepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public PageResult<DepartmentModel> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageResult<DepartmentModel> page = new PageResult<DepartmentModel>(params);
		page.setRows(departmentDao.list(params));
		page.setTotal(departmentDao.count(params));
		return page;
	}

	@Override
	public ResultModel<String> add(DepartmentEntity entity) {
		// TODO Auto-generated method stub
		DepartmentEntity model = departmentDao.getByName(entity.getDepartmentName());
		if(model==null){
			Boolean flag = departmentDao.add(entity);
			if(flag){
				return new ResultModel<String>(true, "添加成功", "");
			}else{
				return new ResultModel<String>(false, "添加失败", "");
			}
		}else{
			if(model.getIsDelete().equals(0)){//已经存在
				return new ResultModel<String>(false, "添加失败,该部门名称已经存在", "");
			}else{
				Boolean flag = departmentDao.addUpdate(entity);
				if(flag){
					return new ResultModel<String>(true, "添加成功", "");
				}else{
					return new ResultModel<String>(false, "添加失败", "");
				}
			}
		}
	}

	@Override
	public ResultModel<String> update(DepartmentEntity entity) {
		// TODO Auto-generated method stub
		Boolean flag = departmentDao.update(entity);
		if(flag){
			return new ResultModel<String>(true, "修改成功", "");
		}else{
			return new ResultModel<String>(false, "修改失败", "");
		}
	}

	@Override
	public ResultModel<String> delete(DepartmentEntity entity) {
		// TODO Auto-generated method stub
		Boolean flag = departmentDao.delete(entity);
		if(flag){
			return new ResultModel<String>(true, "删除成功", "");
		}else{
			return new ResultModel<String>(false, "删除失败", "");
		}
	}

	@Override
	public ResultModel<DepartmentModel> detail(Integer id) {
		// TODO Auto-generated method stub
		DepartmentModel model = departmentDao.detail(id);
		if(model!=null){
			return CommonUtils.returnModel(model);
		}
		return CommonUtils.returnModel("部门信息不存在...");
	}

	@Override
	public List<ComboboxModel> droplist() {
		// TODO Auto-generated method stub
		return departmentDao.dropdownList();
	}

}
