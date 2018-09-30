<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/selector/role.js"></script>
<div id="kytc_system_selector_role_main_div" style="width:100%;height:100%;">
	<form name="search_form" class="search_form">
		<table>
			<tr>
				<td>角色:</td>
				<td><input class="easyui-textbox" name="roleName"></td>
				<td>所属部门:</td>
				<td><input id="kytc_system_selector_role_dept_main_div" name="departmentId"></td>
				<td>角色类型:</td>
				<td>
					<select class="easyui-combobox" name="type" style="width:150px;height:32px;">
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
	<div name="list">
		<table id="kytc_system_selector_role_main_div_list" style="overflow:auto;width:100%;height:100%;"></table>
	</div>
	<div class="btn_div" name="btn_div" style="width:100%;height:40px;margin-top:10px;text-align:center;">
		<a name="sure" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a name="close" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-close'">关闭</a>
	</div>
</div>