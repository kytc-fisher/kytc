package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.TitleEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.base.TitleModel;

/**
 * @author 何志同
 * @description 职务的操作列表
 * @date 2017年5月30日下午1:54:09
 * @link_table kytc_base_title
 */
public interface TitleDao {
	/**
	 * @author 何志同
	 * @description 获取数据源
	 * @date 2017年5月30日下午1:55:43
	 * @param params
	 * @return List<TitleModel>
	 */
	public List<TitleModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 获取数据条数
	 * @date 2017年5月30日下午1:57:09
	 * @param params
	 * @return Integer
	 */
	public Integer count(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加
	 * @date 2017年5月30日下午2:01:09
	 * @param entity
	 * @return Integer
	 */
	public Boolean add(TitleEntity entity);
	/**
	 * @author 何志同
	 * @description 修改
	 * @date 2017年5月30日下午2:01:18
	 * @param entity
	 * @return Integer
	 */
	public Boolean update(TitleEntity entity);
	/**
	 * @author 何志同
	 * @description 查看详情
	 * @date 2017年5月30日下午2:01:36
	 * @param id
	 * @return TitleModel
	 */
	public TitleModel detail(Integer id);
	/**
	 * @author 何志同
	 * @description 删除
	 * @date 2017年5月30日下午2:01:48
	 * @param entity
	 * @return Integer
	 */
	public Boolean delete(TitleEntity entity);
	/**
	 * @author 何志同
	 * @description 根据名字获取职务
	 * @date 2017年5月30日下午2:36:25
	 * @param name
	 * @return TitleEntity
	 */
	public TitleEntity getByName(String name);
	/**
	 * @author 何志同
	 * @description 当数据存在时进行更新
	 * @date 2017年5月30日下午2:38:31
	 * @param entity
	 * @return Boolean
	 */
	public Boolean addUpdate(TitleEntity entity);
	/**
	 * @author 何志同
	 * @description 获取下拉框数据源
	 * @date 2017年5月30日下午3:24:23
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> dropdownList();
}
