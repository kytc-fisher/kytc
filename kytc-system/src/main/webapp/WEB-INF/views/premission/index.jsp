<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.kytc.com/premission/auth" prefix="auth"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/premission/index.js"></script>
<div id="kytc_system_premission_main_div" style="width:100%;height:100%;">
	<form name="search_form" class="search_form">
		<table>
			<tr>
				<td>ID:</td>
				<td>
					<input class="easyui-textbox" name="id">
				</td>
				<td>项目:</td>
				<td><input id="kytc_system_premission_main_div_project" name="project"></td>
				<td>模块:</td>
				<td>
					<input class="easyui-combobox" id="kytc_system_premission_main_div_module" name="module">
				</td>
			</tr>
			<tr>
				<td>菜单:</td>
				<td><input name="menu" class="easyui-combobox" id="kytc_system_premission_main_div_menu"></td>
				<td>操作:</td>
				<td><input name="operator" class="easyui-combobox" id="kytc_system_premission_main_div_operator"></td>
				<td>权限:</td>
				<td><input name="premission" class="easyui-textbox"></td>
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
		<auth:premission premission="kytc:system:base:premission:add"><a name="add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:premission:edit"><a name="update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:premission:delete"><a name="delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-delete'">删除</a></auth:premission>
	</div>
	<div name="list">
		<table id="kytc_system_premission_main_div_list" style="overflow:auto;width:100%;height:100%;"></table>
	</div>
</div>