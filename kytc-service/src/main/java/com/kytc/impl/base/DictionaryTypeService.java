package com.kytc.impl.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.DictionaryTypeDao;
import com.kytc.entity.base.DictionaryTypeEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DictionaryTypeModel;
import com.kytc.service.base.IDictionaryTypeService;
import com.kytc.utils.CommonUtils;

@Service("dictionaryTypeService")
public class DictionaryTypeService implements IDictionaryTypeService{
	@Autowired
	private DictionaryTypeDao dictionaryTypeDao;
	@Override
	public PageResult<DictionaryTypeEntity> pageResult(Map<String,Object> params){
		PageResult<DictionaryTypeEntity> pageResult = new PageResult<DictionaryTypeEntity>(params);
		List<DictionaryTypeEntity> list = dictionaryTypeDao.list(params);
		Integer count = dictionaryTypeDao.count(params);
		pageResult.setRows(list);
		pageResult.setTotal(count);
		return pageResult;
	}
	@Override
	public ResultModel<String> add(DictionaryTypeEntity entity){
		DictionaryTypeEntity en = dictionaryTypeDao.getByCode(entity.getCode());
		if(en==null){
			en = dictionaryTypeDao.getByName(entity.getName());
			if(en==null){
				Boolean result = dictionaryTypeDao.add(entity);
				if(result){
					return CommonUtils.returnModel(true,"添加成功",null);
				}else{
					return CommonUtils.returnModel(false,"添加失败",null);
				}
			}else if(en.getIsDelete()==1){
				entity.setId(en.getId());
				Boolean result = dictionaryTypeDao.addUpdate(entity);
				if(result){
					return CommonUtils.returnModel(true,"添加成功",null);
				}else{
					return CommonUtils.returnModel(false,"添加失败",null);
				}
			}else{
				return CommonUtils.returnModel(false,"该名称已经存在,添加失败",null);
			}
		}else if(en.getIsDelete()==1){
			entity.setId(en.getId());
			Boolean result = dictionaryTypeDao.addUpdate(entity);
			if(result){
				return CommonUtils.returnModel(true,"添加成功",null);
			}else{
				return CommonUtils.returnModel(false,"添加失败",null);
			}
		}else{
			return CommonUtils.returnModel(false,"该编码已经存在,添加失败",null);
		}
	}
	@Override
	public ResultModel<String> update(DictionaryTypeEntity entity){
		DictionaryTypeEntity en = dictionaryTypeDao.getByName(entity.getName());
		if(en==null||en.getIsDelete()==1||en.getCode().equals(entity.getCode())){
			Boolean result = dictionaryTypeDao.update(entity);
			if(result){
				return CommonUtils.returnModel(true,"修改成功",null);
			}else{
				return CommonUtils.returnModel(false,"修改失败",null);
			}
		}else{
			return CommonUtils.returnModel(false,"类型名称已存在,请重新输入...",null);
		}
	}
	@Override
	public ResultModel<String> delete(DictionaryTypeEntity entity){
		Boolean result = dictionaryTypeDao.delete(entity);
		if(result){
			return CommonUtils.returnModel(true,"删除成功",null);
		}else{
			return CommonUtils.returnModel(false,"删除失败",null);
		}
	}
	@Override
	public ResultModel<DictionaryTypeModel> detail(Integer id){
		return CommonUtils.returnModel(dictionaryTypeDao.detail(id));
	}
	@Override
	public List<ComboboxModel> droplist() {
		// TODO Auto-generated method stub
		return dictionaryTypeDao.droplist();
	}
	@Override
	public ResultModel<DictionaryTypeEntity> getById(Integer id) {
		// TODO Auto-generated method stub
		return CommonUtils.returnModel(dictionaryTypeDao.getById(id));
	}
}