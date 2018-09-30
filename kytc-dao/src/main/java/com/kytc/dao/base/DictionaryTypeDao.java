package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.DictionaryTypeEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.base.DictionaryTypeModel;

public interface DictionaryTypeDao{
	/**
	 * @author 何志同
	 * @description 获取数据源
	 * @date 2017年6月7日下午10:42:19
	 * @param params
	 * @return List<DictionaryTypeEntity>
	 */
	public List<DictionaryTypeEntity> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 获取条数
	 * @date 2017年6月7日下午10:42:29
	 * @param params
	 * @return Integer
	 */
	public Integer count(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加
	 * @date 2017年6月7日下午10:42:41
	 * @param entity
	 * @return Boolean
	 */
	public Boolean add(DictionaryTypeEntity entity);
	/**
	 * @author 何志同
	 * @description 添加已经删除的数据
	 * @date 2017年6月10日下午1:04:04
	 * @param entity
	 * @return Boolean
	 */
	public Boolean addUpdate(DictionaryTypeEntity entity);
	/**
	 * @author 何志同
	 * @description 修改
	 * @date 2017年6月7日下午10:43:49
	 * @param entity
	 * @return Boolean
	 */
	public Boolean update(DictionaryTypeEntity entity);
	/**
	 * @author 何志同
	 * @description 删除
	 * @date 2017年6月7日下午10:44:05
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(DictionaryTypeEntity entity);
	/**
	 * @author 何志同
	 * @description 查询详情
	 * @date 2017年6月7日下午10:44:19
	 * @param code
	 * @return DictionaryTypeEntity
	 */
	public DictionaryTypeEntity getByCode(String code);
	/**
	 * @author 何志同
	 * @description 
	 * @date 2017年6月7日下午11:02:53
	 * @param name
	 * @return DictionaryTypeEntity
	 */
	public DictionaryTypeEntity getByName(String name);
	/**
	 * @author 何志同
	 * @description 查询详情
	 * @date 2017年6月7日下午10:48:59
	 * @param id
	 * @return DictionaryTypeModel
	 */
	public DictionaryTypeModel detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取下拉框数据源
	 * @date 2017年6月10日上午9:12:00
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> droplist();
	/**
	 * @author 何志同
	 * @description 根据ID获取字典类型详情
	 * @date 2017年6月10日下午12:52:11
	 * @param id
	 * @return DictionaryTypeEntity
	 */
	public DictionaryTypeEntity getById(Integer id);
}