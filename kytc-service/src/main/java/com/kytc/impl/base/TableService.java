package com.kytc.impl.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kytc.dao.base.TableDao;
import com.kytc.model.ResultModel;
import com.kytc.model.base.TableColumnModel;
import com.kytc.service.base.ITableService;
import com.kytc.utils.DataBaseUtils;
@Service("tableService")
public class TableService implements ITableService {
	@Autowired
	private TableDao tableDao;
	@Override
	public ResultModel<String> toFile(String tableName, String tableSchema) {
		// TODO Auto-generated method stub
		List<TableColumnModel> list = tableDao.getColumn(tableName, tableSchema);
		return DataBaseUtils.toFile("D:\\", tableName, list);
	}

}
