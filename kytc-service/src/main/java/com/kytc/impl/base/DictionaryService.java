package com.kytc.impl.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.DictionaryDao;
import com.kytc.entity.base.DictionaryEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DictionaryModel;
import com.kytc.service.base.IDictionaryService;
import com.kytc.utils.CommonUtils;

@Service("dictionaryService")
public class DictionaryService implements IDictionaryService{
	@Autowired
	private DictionaryDao dictionaryDao;
	@Override
	public PageResult<DictionaryModel> pageResult(Map<String,Object> params){
		PageResult<DictionaryModel> pageResult = new PageResult<DictionaryModel>(params);
		List<DictionaryModel> list = dictionaryDao.list(params);
		Integer count = dictionaryDao.count(params);
		pageResult.setRows(list);
		pageResult.setTotal(count);
		return pageResult;
	}
	public ResultModel<String> add(DictionaryEntity entity){
		DictionaryEntity en = dictionaryDao.getByTypeAndCode(entity.getType(), entity.getCode());
		if(en==null){
			en = dictionaryDao.getByTypeAndName(entity.getType(), entity.getName());
			if(en==null){
				Boolean result = dictionaryDao.add(entity);
				if(result){
					return CommonUtils.returnModel(true,"添加成功",null);
				}else{
					return CommonUtils.returnModel(false,"添加失败",null);
				}
			}else if(en.getIsDelete()==1){
				Boolean result = dictionaryDao.addUpdate(entity);
				if(result){
					return CommonUtils.returnModel(true,"添加成功",null);
				}else{
					return CommonUtils.returnModel(false,"添加失败",null);
				}
			}else{
				return CommonUtils.returnModel(false,"该名称已经存在,添加失败",null);
			}
		}else if(en.getIsDelete()==1){
			Boolean result = dictionaryDao.addUpdate(entity);
			if(result){
				return CommonUtils.returnModel(true,"添加成功",null);
			}else{
				return CommonUtils.returnModel(false,"添加失败",null);
			}
		}else{
			return CommonUtils.returnModel(false,"该编码已经存在,添加失败",null);
		}
	}
	public ResultModel<String> update(DictionaryEntity entity){
		DictionaryEntity en = dictionaryDao.getByTypeAndCode(entity.getType(), entity.getCode());
		if(en==null||en.getIsDelete()==1||en.getId().equals(entity.getId())){
			en = dictionaryDao.getByTypeAndName(entity.getType(), entity.getName());
			if(en==null||en.getIsDelete()==1||en.getId().equals(entity.getId())){
				Boolean result = dictionaryDao.update(entity);
				if(result){
					return CommonUtils.returnModel(true,"修改成功",null);
				}else{
					return CommonUtils.returnModel(false,"修改失败",null);
				}
			}else{
				return CommonUtils.returnModel(false,"该名称已经存在",null);
			}
		}else{
			return CommonUtils.returnModel(false,"该编码已经存在",null);
		}
	}
	public ResultModel<String> delete(DictionaryEntity entity){
		Boolean result = dictionaryDao.delete(entity);
		if(result){
			return CommonUtils.returnModel(true,"删除成功",null);
		}else{
			return CommonUtils.returnModel(false,"删除失败",null);
		}
	}
	public ResultModel<DictionaryModel> detail(Integer id){
		return CommonUtils.returnModel(dictionaryDao.detail(id));
	}
	@Override
	public ResultModel<DictionaryModel> getById(Integer id) {
		// TODO Auto-generated method stub
		return CommonUtils.returnModel(true,"",dictionaryDao.getById(id));
	}
	@Override
	public List<ComboboxModel> droplist(String type) {
		// TODO Auto-generated method stub
		return dictionaryDao.droplist1(type);
	}
	@Override
	public List<ComboboxModel> droplist(String parentType, String parentCode,
			String type) {
		// TODO Auto-generated method stub
		return dictionaryDao.droplist2(parentType, parentCode, type);
	}
}