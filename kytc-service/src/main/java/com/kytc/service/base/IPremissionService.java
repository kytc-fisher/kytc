package com.kytc.service.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.PremissionEntity;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.PremissionModel;
import com.kytc.model.base.premission.ProjectModel;

public interface IPremissionService {
	/**
	 * @author 何志同
	 * @description 获取分页数据源
	 * @date 2017年6月10日下午6:19:39
	 * @param params
	 * @return PageResult<PremissionModel>
	 */
	public PageResult<PremissionModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加权限
	 * @date 2017年6月10日下午6:19:57
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(PremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 修改权限
	 * @date 2017年6月10日下午6:20:31
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> update(PremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 删除权限
	 * @date 2017年6月10日下午6:20:45
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(PremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 查看权限详情
	 * @date 2017年6月10日下午6:21:03
	 * @param id
	 * @return ResultModel<PremissionModel>
	 */
	public ResultModel<PremissionModel> detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取详情
	 * @date 2017年6月10日下午6:23:00
	 * @param id
	 * @return ResultModel<PremissionEntity>
	 */
	public ResultModel<PremissionEntity> getById(Integer id);
	/**
	 * @author 何志同
	 * @description 
	 * @date 2017年6月11日下午6:50:11
	 * @param project 项目
	 * @param module 模块
	 * @param menu 菜单
	 * @param operator 操作
	 * @return ResultModel<String>
	 */
	public ResultModel<String> addBetch(String project,String module,String menu,String operator);
	/**
	 * @author 何志同
	 * @description 获取权限列表
	 * @date 2017年6月11日下午8:16:50
	 * @return List<Map<String,Object>>
	 */
	public List<ProjectModel> getPremissions();
}
