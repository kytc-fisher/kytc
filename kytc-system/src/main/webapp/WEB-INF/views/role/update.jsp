<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/role/update.js"></script>
<div id="kytc_system_role_update_main_div" style="width:100%;height:100%;">
	<table class="detail_small_table">
		<tbody>
			<tr>
				<td>部门:</td>
				<td>
					<input type="hidden" value="${result.data.id }" name="id"/>
					<input id="kytc_system_role_update_main_div_dept" data-original="${result.data.departmentId }" name="departmentId">
				</td>
			</tr>
			<tr>
				<td>角色名称:</td>
				<td><input class="easyui-textbox" value="${result.data.roleName }" name="roleName" data-options="required:true"></td>
			</tr>
			<tr>
				<td>角色类型:</td>
				<td>
					<select class="easyui-validatebox easyui-combobox" name="type" data-options="required:true">
						<option value="" selected="selected">--请选择--</option>
					    <option value="1" <c:if test="${result.data.type==1 }">selected</c:if>>共享角色</option>
					    <option value="2" <c:if test="${result.data.type==2 }">selected</c:if>>部门角色</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>排序号:</td>
				<td><input class="easyui-numberspinner easyui-validatebox" value="${result.data.sortNum }" name="sortNum" data-options="increment:1,min:1,required:true"></td>
			</tr>
			<tr>
				<td>描述:</td>
				<td>
					<textarea name="description" class="textbox" rows="3" cols="5" style="width:292px;height:80px;">${result.data.description }</textarea>
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