<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/role/add.js"></script>
<div id="kytc_system_role_add_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
			<tr>
				<td>部门:</td>
				<td><input id="kytc_system_role_add_main_div_dept" name="departmentId"></td>
			</tr>
			<tr>
				<td>角色名称:</td>
				<td><input class="easyui-textbox" name="roleName" data-options="required:true"></td>
			</tr>
			<tr>
				<td>角色类型:</td>
				<td>
					<select class="easyui-validatebox easyui-combobox" name="type" data-options="required:true">
						<option value="" selected="selected">--请选择--</option>
					    <option value="1">共享角色</option>
					    <option value="2">部门角色</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>排序号:</td>
				<td><input class="easyui-numberspinner easyui-validatebox" name="sortNum" data-options="increment:1,min:1,required:true"></td>
			</tr>
			<tr>
				<td>描述:</td>
				<td>
					<textarea name="description" class="textbox" rows="3" cols="5" style="width:292px;height:80px;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="btn_div">
						<a name="save" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
						<a name="close" class="easyui-linkbutton" data-options="iconCls:'icon-close'">关闭</a>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>