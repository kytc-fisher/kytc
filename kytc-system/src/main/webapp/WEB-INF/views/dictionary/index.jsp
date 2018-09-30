<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.kytc.com/premission/auth" prefix="auth"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dictionary/index.js"></script>
<div id="kytc_system_dictionary_main_div" style="width:100%;height:100%;">
	<form name="search_form" class="search_form">
		<table>
			<tr>
				<td>ID:</td>
				<td>
					<input class="easyui-textbox" name="id">
				</td>
				<td>编码:</td>
				<td><input class="easyui-textbox" name="code"></td>
				<td>名称:</td>
				<td>
					<input class="easyui-textbox" name="name">
				</td>
			</tr>
			<tr>
				<td>字典类型:</td>
				<td><input name="type" id="kytc_system_dictionary_main_div_type"></td>
				<td>上级类型:</td>
				<td><input name="parentType" id="kytc_system_dictionary_main_div_parent_type"></td>
				<td>上级编码:</td>
				<td><input name="parentCode" id="kytc_system_dictionary_main_div_parent_code" class="easyui-combobox"></td>
			</tr>
			<tr>
				<td colspan="6">
					<div>
						<a name="search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
						<a name="reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<div class="btn_div" name="btn_div" style="width:100%;height:40px;margin-top:10px;margin-bottom:10px;">
		<auth:premission premission="kytc:system:base:dictionary:add"><a name="add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:dictionary:edit"><a name="update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:dictionary:delete"><a name="delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-delete'">删除</a></auth:premission>
	</div>
	<div name="list">
		<table id="kytc_system_dictionary_main_div_list" style="overflow:auto;width:100%;height:100%;"></table>
	</div>
</div>