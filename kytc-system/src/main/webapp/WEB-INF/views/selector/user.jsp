<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/selector/user.js"></script>
<div id="kytc_system_selector_user_main_div" style="width:100%;height:100%;">
	<form name="search_form" class="search_form">
		<table>
			<tr>
				<td>用户id:</td>
				<td><input class="easyui-textbox" name="id" style="width:150px;height:32px"></td>
				<td>用户名:</td>
				<td><input class="easyui-textbox" name="nickName" style="width:150px;height:32px"></td>
				<td>性别:</td>
				<td>
					<select class="easyui-combobox" name="sex" style="width:150px;height:32px;">
						<option value="" selected="selected">--请选择--</option>
					    <option value="0">未知的性别</option>
					    <option value="1">男性</option>
					    <option value="2">女性</option>
					    <option value="5">女性改（变）为男性</option>
					    <option value="6">男性改（变）为女性</option>
					    <option value="9">未说明的性别</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>部门:</td>
				<td><input id="kytc_system_selector_user_dept_main_div" name="departmentId"/></td>
				<td>职务:</td>
				<td><input id="kytc_system_selector_user_title_main_div" name="titleId"/></td>
				<td>是否登陆:</td>
				<td>
					<select class="easyui-combobox" name="isLogin" style="width:150px;height:32px;">
						<option value="" selected="selected">--请选择--</option>
					    <option value="0">否</option>
					    <option value="1">是</option>
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
		<table id="kytc_system_selector_user_main_div_list" style="overflow:auto;width:100%;height:100%;"></table>
	</div>
	<div class="btn_div" name="btn_div" style="width:100%;height:40px;margin-top:10px;text-align:center;">
		<a name="sure" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a name="close" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">关闭</a>
	</div>
</div>