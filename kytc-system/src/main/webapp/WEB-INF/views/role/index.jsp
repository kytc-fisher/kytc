<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.kytc.com/premission/auth" prefix="auth"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/role/index.js"></script>
<div id="kytc_system_role_main_div" style="width:100%;height:100%;">
	<form name="search_form" class="search_form">
		<table>
			<tr>
				<td>角色名称:</td>
				<td>
					<input class="easyui-textbox" name="roleName">
				</td>
				<td>所属部门:</td>
				<td><input id="kytc_system_role_main_div_dept" name="departmentId"></td>
				<td>角色类型:</td>
				<td>
					<select class="easyui-validatebox easyui-combobox" name="type">
						<option value="" selected="selected">--请选择--</option>
					    <option value="1">共享角色</option>
					    <option value="2">部门角色</option>
					</select>
				</td>
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
		<auth:premission premission="kytc:system:base:role:add"><a name="add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:role:edit"><a name="update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:edit:set"><a name="set" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-set'">设置权限</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:edit:delete"><a name="delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-delete'">删除</a></auth:premission>
	</div>
	<div name="list">
		<table id="kytc_system_role_main_div_list" style="overflow:auto;width:100%;height:100%;"></table>
	</div>
</div>