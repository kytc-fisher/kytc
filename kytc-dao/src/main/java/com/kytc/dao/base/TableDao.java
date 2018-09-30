package com.kytc.dao.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kytc.model.base.TableColumnModel;

public interface TableDao {
	/**
	 * @author 何志同
	 * @description 根据表名称和数据库名称获取数据库的列信息
	 * @date 2017年6月7日下午9:59:18
	 * @param tableName
	 * @param tableSchema
	 * @return List<Map<String,Object>>
	 */
	public List<TableColumnModel> getColumn(@Param("tableName") String tableName,
			@Param("tableSchema") String tableSchema);
}
