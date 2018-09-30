package com.kytc.service.base;

import java.util.List;
import java.util.Map;

import com.kytc.entity.base.TitleEntity;
import com.kytc.model.ComboboxModel;
import com.kytc.model.PageResult;
import com.kytc.model.ResultModel;
import com.kytc.model.base.TitleModel;

/**
 * @author 何志同
 * @description 职务的service层
 * @date 2017年5月30日下午3:27:28
 */
public interface ITitleService {
	/**
	 * @author 何志同
	 * @description 获取职务的数据源
	 * @date 2017年5月30日下午3:28:33
	 * @param params
	 * @return PageResult<TitleModel>
	 */
	public PageResult<TitleModel> list(Map<String,Object> params);
	/**
	 * @author 何志同
	 * @description 添加职务信息
	 * @date 2017年5月30日下午3:29:51
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> add(TitleEntity entity);
	/**
	 * @author 何志同
	 * @description 修改
	 * @date 2017年5月30日下午3:31:59
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> update(TitleEntity entity);
	/**
	 * @author 何志同
	 * @description 删除
	 * @date 2017年5月30日下午3:32:08
	 * @param entity
	 * @return ResultModel<String>
	 */
	public ResultModel<String> delete(TitleEntity entity);
	/**
	 * @author 何志同
	 * @description 查看详情
	 * @date 2017年5月30日下午3:32:56
	 * @param id
	 * @return ResultModel<TitleModel>
	 */
	public ResultModel<TitleModel> detail(Integer id);
	/**
	 * @author 何志同
	 * @description 获取下拉框数据源
	 * @date 2017年5月30日下午3:33:06
	 * @return ResultModel<List<ComboboxModel>>
	 */
	public List<ComboboxModel> droplist();
}
