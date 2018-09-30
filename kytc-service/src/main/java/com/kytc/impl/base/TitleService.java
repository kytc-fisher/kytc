package com.kytc.impl.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.TitleDao;
import com.kytc.entity.base.TitleEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.TitleModel;
import com.kytc.service.base.ITitleService;
import com.kytc.utils.CommonUtils;
@Service("titleService")
public class TitleService implements ITitleService {
	@Autowired
	private TitleDao titleDao;
	@Override
	public PageResult<TitleModel> list(Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageResult<TitleModel> page = new PageResult<TitleModel>(params);
		page.setRows(titleDao.list(params));
		page.setTotal(titleDao.count(params));
		return page;
	}
	@Override
	public ResultModel<String> add(TitleEntity entity) {
		// TODO Auto-generated method stub
		TitleEntity model = titleDao.getByName(entity.getName());
		if(model==null){
			Boolean flag = titleDao.add(entity);
			if(flag){
				return new ResultModel<String>(true, "添加成功", "");
			}else{
				return new ResultModel<String>(false, "添加失败", "");
			}
		}else{
			if(model.getIsDelete().equals(0)){//已经存在
				return new ResultModel<String>(false, "添加失败,该职务已经存在", "");
			}else{
				Boolean flag = titleDao.addUpdate(entity);
				if(flag){
					return new ResultModel<String>(true, "添加成功", "");
				}else{
					return new ResultModel<String>(false, "添加失败", "");
				}
			}
		}
	}

	@Override
	public ResultModel<String> update(TitleEntity entity) {
		// TODO Auto-generated method stub
		Boolean flag = titleDao.update(entity);
		if(flag){
			return new ResultModel<String>(true, "修改成功", "");
		}else{
			return new ResultModel<String>(false, "修改失败", "");
		}
	}

	@Override
	public ResultModel<String> delete(TitleEntity entity) {
		// TODO Auto-generated method stub
		Boolean flag = titleDao.delete(entity);
		if(flag){
			return new ResultModel<String>(true, "删除成功", "");
		}else{
			return new ResultModel<String>(false, "删除失败", "");
		}
	}

	@Override
	public ResultModel<TitleModel> detail(Integer id) {
		// TODO Auto-generated method stub
		TitleModel model = titleDao.detail(id);
		if(model!=null){
			return CommonUtils.returnModel(model);
		}
		return CommonUtils.returnModel("职务信息不存在...");
	}

	@Override
	public List<ComboboxModel> droplist() {
		// TODO Auto-generated method stub
		return titleDao.dropdownList();
	}

}
