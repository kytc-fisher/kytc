package com.kytc.service.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.DictionaryTypeEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DictionaryTypeModel;

public interface IDictionaryTypeService{
	/**
	 * @author 何志同
	 * @description 获取分页数据源
	 * @date 2017年6月10日上午8:52:06
	 * @param params
	 * @return PageResult<DictionaryTypeModel>
	 */
	public PageResult<DictionaryTypeEntity> pageResult(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加数据字典类型
	 * @date 2017年6月10日上午8:52:24
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(DictionaryTypeEntity entity);
	/**
	 * @author 何志同
	 * @description 修改数据字典类型
	 * @date 2017年6月10日上午8:53:40
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> update(DictionaryTypeEntity entity);
	/**
	 * @author 何志同
	 * @description 删除数据字典类型
	 * @date 2017年6月10日上午8:53:54
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(DictionaryTypeEntity entity);
	/**
	 * @author 何志同
	 * @description 
	 * @date 2017年6月10日上午8:54:26
	 * @param id
	 * @return ResultModel<DictionaryTypeModel>
	 */
	public ResultModel<DictionaryTypeModel> detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取下拉数据源
	 * @date 2017年6月10日上午8:59:04
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> droplist();
	/**
	 * @author 何志同
	 * @description 根据ID获取字典类型详情
	 * @date 2017年6月10日下午12:50:50
	 * @param id
	 * @return ResultModel<DictionaryTypeEntity>
	 */
	public ResultModel<DictionaryTypeEntity> getById(Integer id);
}