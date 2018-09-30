<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/department/update.js"></script>
<div id="kytc_system_dept_update_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
		<tr>
			<td>部门名称:</td>
			<td>
				${result.data.departmentName }
				<input type="hidden" value="${result.data.id }" name="id"/>
				<input type="hidden" value="${result.data.departmentName }" name="departmentName"/>
			</td>
			<td>部门简称:</td>
			<td><input value="${result.data.shortName }" class="easyui-validatebox textbox" name="shortName" data-options="prompt:'请输入部门简称...',required:true"></td>
		</tr>
		<tr>
			<td>英文名称:</td>
			<td><input class="easyui-textbox" name="englishName" value="${result.data.englishName }"></td>
			<td>建立时间:</td>
			<td><input value="${result.data.establishTime }" class="easyui-validatebox easyui-datebox" name="establishTime" data-options="required:true"></td>
		</tr>
		<tr>
			<td>上级部门:</td>
			<td>
				<input data-original="${result.data.parentId}" id="kytc_system_dept_update_parent_main_div" name="parentId">
			</td>
			<td>部门领导:</td>
			<td>
				<input value="${result.data.leaderName }" id="kytc_system_dept_update_leader_main_div" class="easyui-searchbox" name="leaderName" data-options="required:true">
				<input value="${result.data.leaderId }" name="leaderId" type="hidden"/>
			</td>
		</tr>
		<tr>
			<td>排序号:</td>
			<td colspan="3"><input value="${result.data.sortNum }" class="easyui-numberspinner easyui-validatebox" name="sortNum" data-options="increment:1,min:1,required:true"></td>
		</tr>
		<tr>
			<td>部门描述:</td>
			<td colspan="3">
				<textarea class="textbox" name="description" rows="3" cols="5" style="width:592px;height:80px;">${result.data.description }</textarea>
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