package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.DepartmentEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.base.DepartmentModel;

/**
 * @author 何志同
 * @description 部门的底层操作
 * @date 2017年5月30日下午2:50:07
 * @link_table kytc_base_department
 */
public interface DepartmentDao {
	/**
	 * @author 何志同
	 * @description 部门的数据源
	 * @date 2017年5月30日下午2:51:26
	 * @param params
	 * @return List<DepartmentModel>
	 */
	public List<DepartmentModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 获取部门条数
	 * @date 2017年5月30日下午2:51:56
	 * @param params
	 * @return Integer
	 */
	public Integer count(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加
	 * @date 2017年5月30日下午2:54:37
	 * @param entity
	 * @return Boolean
	 */
	public Boolean add(DepartmentEntity entity);
	/**
	 * @author 何志同
	 * @description 修改
	 * @date 2017年5月30日下午2:54:46
	 * @param entity
	 * @return Boolean
	 */
	public Boolean update(DepartmentEntity entity);
	/**
	 * @author 何志同
	 * @description 删除(虚拟删除)
	 * @date 2017年5月30日下午2:54:56
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(DepartmentEntity entity);
	/**
	 * @author 何志同
	 * @description 获取部门详情
	 * @date 2017年5月30日下午2:55:16
	 * @param id
	 * @return DepartmentModel
	 */
	public DepartmentModel detail(Integer id);
	/**
	 * @author 何志同
	 * @description 根据部门名称获取部门信息
	 * @date 2017年5月30日下午2:55:37
	 * @param departmentName
	 * @return DepartmentEntity
	 */
	public DepartmentEntity getByName(String departmentName);
	/**
	 * @author 何志同
	 * @description 添加虚拟删除的部门信息
	 * @date 2017年5月30日下午2:55:51
	 * @param entity
	 * @return Boolean
	 */
	public Boolean addUpdate(DepartmentEntity entity);
	/**
	 * @author 何志同
	 * @description 获取部门下拉框数据源
	 * @date 2017年5月31日下午9:56:17
	 * @return List<ComboboxModel>
	 */
	public List<ComboboxModel> dropdownList();
}
