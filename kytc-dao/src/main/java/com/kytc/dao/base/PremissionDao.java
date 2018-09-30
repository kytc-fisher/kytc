package com.kytc.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kytc.entity.base.PremissionEntity;
import com.kytc.model.base.PremissionModel;

/**
 * @author 何志同
 * @description 权限表操作
 * @date 2017年6月4日下午9:50:08
 * @link_table kytc_base_premission
 */
public interface PremissionDao {
	/**
	 * @author 何志同
	 * @description 添加
	 * @date 2017年6月4日下午9:51:02
	 * @param entity
	 * @return Boolean
	 */
	public Boolean add(PremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 修改权限表
	 * @date 2017年6月4日下午9:53:50
	 * @param entity
	 * @return Boolean
	 */
	public Boolean update(PremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 删除
	 * @date 2017年6月4日下午9:54:01
	 * @param entity
	 * @return Boolean
	 */
	public Boolean delete(PremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 根据id获取entity
	 * @date 2017年6月4日下午9:54:12
	 * @param id
	 * @return PremissionEntity
	 */
	public PremissionEntity getById(Integer id);
	/**
	 * @author 何志同
	 * @description 查看权限详情
	 * @date 2017年6月4日下午9:54:29
	 * @param id
	 * @return PremissionModel
	 */
	public PremissionModel detail(Integer id);
	/**
	 * @author 何志同
	 * @description 数据源
	 * @date 2017年6月4日下午9:54:44
	 * @param params
	 * @return List<PremissionEntity>
	 */
	public List<PremissionModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 条数
	 * @date 2017年6月4日下午9:54:55
	 * @param params
	 * @return Integer
	 */
	public Integer count(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 根据权限获取信息
	 * @date 2017年6月10日下午7:11:29
	 * @param premission
	 * @return PremissionEntity
	 */
	public PremissionEntity getByPremission(String premission);
	/**
	 * @author 何志同
	 * @description 根据模块获取信息
	 * @date 2017年6月10日下午7:14:21
	 * @param project
	 * @param module
	 * @param menu
	 * @param operator
	 * @return PremissionEntity
	 */
	public PremissionEntity getByParams(@Param("project")String project,
			@Param("module")String module,@Param("menu")String menu,@Param("operator")String operator);
	/**
	 * @author 何志同
	 * @description 添加已经删除的权限
	 * @date 2017年6月10日下午7:22:48
	 * @param entity
	 * @return Boolean
	 */
	public Boolean addUpdate(PremissionEntity entity);
	/**
	 * @author 何志同
	 * @description 获取所有权限
	 * @date 2017年6月11日下午8:13:26
	 * @return List<PremissionModel>
	 */
	public List<PremissionModel> getPremissions();
}
