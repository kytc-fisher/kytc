package com.kytc.service.base;

import com.kytc.model.ResultModel;

/**
 * @author 何志同
 * @description 关于数据表的操作
 * @date 2017年6月7日下午10:08:55
 */
public interface ITableService {
	/**
	 * @author 何志同
	 * @description 转为文件
	 * @date 2017年6月7日下午10:10:02
	 * @param tableName 表名
	 * @param tableSchema 数据库名
	 * @return ResultModel<String>
	 */
	public ResultModel<String> toFile(String tableName,String tableSchema);
}
