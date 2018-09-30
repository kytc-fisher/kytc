<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.kytc.com/premission/auth" prefix="auth"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/title/index.js"></script>
<div id="kytc_system_title_main_div" style="width:100%;height:100%;">
	<form name="search_form" class="search_form">
		<table>
			<tr>
				<td>职务id:</td>
				<td><input class="easyui-textbox" name="id" style="width:150px;height:32px"></td>
				<td>职务名称:</td>
				<td>
					<input class="easyui-textbox" name="name" style="width:150px;height:32px">
				</td>
				<td>上级职务:</td>
				<td><input class="easyui-textbox" name="parentName" style="width:150px;height:32px"></td>
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
		<auth:premission premission="kytc:system:base:title:add"><a name="add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:title:edit"><a name="update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a></auth:premission>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<auth:premission premission="kytc:system:base:title:delete"><a name="delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a></auth:premission>
	</div>
	<div name="list">
		<table id="kytc_system_title_main_div_list" style="overflow:auto;width:100%;height:100%;"></table>
	</div>
</div>