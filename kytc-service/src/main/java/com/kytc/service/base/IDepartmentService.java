package com.kytc.service.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.DepartmentEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.DepartmentModel;

/**
 * @author 何志同
 * @description 部门service层操作
 * @date 2017年5月30日下午3:57:48
 */
public interface IDepartmentService {
	/**
	 * @author 何志同
	 * @description 获取数据源
	 * @date 2017年5月30日下午3:59:21
	 * @param params
	 * @return PageResult<DepartmentModel>
	 */
	public PageResult<DepartmentModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加
	 * @date 2017年5月30日下午4:01:05
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(DepartmentEntity entity);
	/**
	 * @author 何志同
	 * @description 修改
	 * @date 2017年5月30日下午4:01:13
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> update(DepartmentEntity entity);
	/**
	 * @author 何志同
	 * @description 
	 * @date 2017年5月30日下午4:01:26
	 * @param entity
	 * @return 
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(DepartmentEntity entity);
	/**
	 * @author 何志同
	 * @description 查看详情
	 * @date 2017年5月30日下午4:01:58
	 * @param id
	 * @return ResultModel<DepartmentModel>
	 */
	public ResultModel<DepartmentModel> detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取部门下拉框数据源
	 * @date 2017年5月30日下午3:33:06
	 * @return ResultModel<List<ComboboxModel>>
	 */
	public List<ComboboxModel> droplist();
}
