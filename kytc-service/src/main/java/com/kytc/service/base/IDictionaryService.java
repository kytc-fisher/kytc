package com.kytc.service.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.DictionaryEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DictionaryModel;

public interface IDictionaryService{
	/**
	 * @author 何志同
	 * @description 获取分页数据源
	 * @date 2017年6月10日上午11:24:58
	 * @param params
	 * @return PageResult<DictionaryModel>
	 */
	public PageResult<DictionaryModel> pageResult(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加数据字典
	 * @date 2017年6月10日上午11:26:12
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(DictionaryEntity entity);
	/**
	 * @author 何志同
	 * @description 修改数据字典
	 * @date 2017年6月10日上午11:26:28
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> update(DictionaryEntity entity);
	/**
	 * @author 何志同
	 * @description 删除数据字典
	 * @date 2017年6月10日上午11:26:42
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(DictionaryEntity entity);
	/**
	 * @author 何志同
	 * @description 查看数据字典详情
	 * @date 2017年6月10日上午11:26:55
	 * @param id
	 * @return ResultModel<DictionaryModel>
	 */
	public ResultModel<DictionaryModel> detail(Integer id);
	/**
	 * @author 何志同
	 * @description 根据id获取字典详情
	 * @date 2017年6月10日下午12:26:10
	 * @param id
	 * @return ResultModel<DictionaryModel>
	 */
	public ResultModel<DictionaryModel> getById(Integer id);
	/**
	 * @author 何志同
	 * @description 下拉数据源
	 * @date 2017年6月10日下午1:22:47
	 * @param type
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> droplist(String type);
	/**
	 * @author 何志同
	 * @description 下拉数据源
	 * @date 2017年6月10日下午1:23:35
	 * @param parentType
	 * @param parentCode
	 * @param type
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> droplist(String parentType,String parentCode,String type);
}