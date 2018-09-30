package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kytc.entity.base.DictionaryEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.base.DictionaryModel;

public interface DictionaryDao{
	/**
	 * @author 何志同
	 * @description 获取数据源
	 * @date 2017年6月10日上午9:44:26
	 * @param params
	 * @return List<DictionaryModel>
	 */
	public List<DictionaryModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 获取数量
	 * @date 2017年6月10日上午9:44:37
	 * @param params
	 * @return Integer
	 */
	public Integer count(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加数据字典
	 * @date 2017年6月10日上午9:44:49
	 * @param entity
	 * @return Boolean
	 */
	public Boolean add(DictionaryEntity entity);
	/**
	 * @author 何志同
	 * @description 更新数据字典
	 * @date 2017年6月10日上午9:45:03
	 * @param entity
	 * @return Boolean
	 */
	public Boolean update(DictionaryEntity entity);
	/**
	 * @author 何志同
	 * @description 删除数据字典
	 * @date 2017年6月10日上午9:45:16
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(DictionaryEntity entity);
	/**
	 * @author 何志同
	 * @description 查看数据字典详情
	 * @date 2017年6月10日上午9:45:36
	 * @param id
	 * @return DictionaryModel
	 */
	public DictionaryModel detail(Integer id);
	/**
	 * @author 何志同
	 * @description 根据字典类型获取下拉数据源
	 * @date 2017年6月10日上午9:46:21
	 * @param type
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> droplist1(String type);
	/**
	 * @author 何志同
	 * @description 根据类型和编码获取字典信息
	 * @date 2017年6月10日上午9:48:00
	 * @param type
	 * @param code
	 * @return DictionaryEntity
	 */
	public DictionaryEntity getByTypeAndCode(@Param("type")String type,
			@Param("code")String code);
	public DictionaryEntity getByTypeAndName(@Param("type")String type,
			@Param("name")String name);
	/**
	 * @author 何志同
	 * @description 根据商机类型和编码来获取数据字典的下拉数据源
	 * @date 2017年6月10日上午9:48:59
	 * @param parentType
	 * @param parentCode
	 * @param type
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> droplist2(@Param("parentType")String parentType,
			@Param("parentCode")String parentCode,@Param("type")String type);
	/**
	 * @author 何志同
	 * @description 添加删除的数据
	 * @date 2017年6月10日下午12:24:38
	 * @param entity
	 * @return Boolean
	 */
	public Boolean addUpdate(DictionaryEntity entity);
	/**
	 * @author 何志同
	 * @description 根据id获取字典详情
	 * @date 2017年6月10日下午12:27:06
	 * @param id
	 * @return DictionaryModel
	 */
	public DictionaryModel getById(Integer id);
}