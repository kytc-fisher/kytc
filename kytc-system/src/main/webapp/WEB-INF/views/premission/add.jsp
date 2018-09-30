<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/premission/add.js"></script>
<div id="kytc_system_premission_add_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
			<tr>
				<td>项目:</td>
				<td><input id="kytc_system_premission_add_main_div_project" name="project" data-options="required:true"></td>
				<td>模块:</td>
				<td><input class="easyui-combobox" id="kytc_system_premission_add_main_div_moudle" name="module" data-options="required:true"></td>
			</tr>
			<tr>
				<td>菜单:</td>
				<td><input class="easyui-combobox" id="kytc_system_premission_add_main_div_menu" name="menu" data-options="required:true"></td>
				<td>操作:</td>
				<td>
					<input class="easyui-combobox" id="kytc_system_premission_add_main_div_operator" name="operator" data-options="required:true">
				</td>
			</tr>
			<tr>
				<td>权限:</td>
				<td colspan="3"><input class="easyui-validatebox easyui-textbox" name="premission" data-options="required:true"></td>
			</tr>
			<tr>
				<td>描述:</td>
				<td colspan="3">
					<textarea name="description" class="textbox" rows="3" cols="5" style="width:592px;height:80px;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="btn_div">
						<a name="save" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
						<a name="close" class="easyui-linkbutton" data-options="iconCls:'icon-close'">关闭</a>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>