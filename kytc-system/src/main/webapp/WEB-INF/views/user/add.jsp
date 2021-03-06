<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/add.js"></script>
<div id="kytc_system_user_add_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
		<tr>
			<td>用户昵称:</td>
			<td><input class="easyui-validatebox easyui-textbox" name="nickName" data-options="required:true"></td>
			<td colspan="2" rowspan="5">
				<img alt="" src="" style="width:140px;height:140px;" name="preview"><br>
				<input name="headPicture" type="hidden">
				<a name="upload" style="margin-left: 43px;padding-top: 10px;cursor: pointer;height: 20px;display: block;text-decoration: underline;color: green;">更换头像</a>
				<form enctype="multipart/form-data" contentType="text/html" action="" name="file" style="display:none;">
					<input type="file" name="file" id="file">
				</form>
			</td>
		</tr>
		<tr>
			<td>真实名字:</td>
			<td><input class="easyui-validatebox easyui-textbox" name="realName" data-options="required:true"></td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>
				<select class="easyui-validatebox easyui-combobox" name="sex" data-options="required:true">
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
			<td>生日:</td>
			<td>
				<input class="easyui-validatebox easyui-datebox" name="birthday" data-options="required:true">
			</td>
		</tr>
		<tr>
			<td>身份证号:</td>
			<td><input class="easyui-validatebox easyui-textbox" name="idCard" data-options="required:true"></td>
		</tr>
		<tr>
			<td>电子邮箱:</td>
			<td><input name="email" class="easyui-validatebox easyui-textbox" data-options="prompt:'请输入邮箱...',required:true,validType:'email'"></td>
			<td>手机号:</td>
			<td><input name="phone" class="easyui-textbox" style="width:150px;height:32px"></td>
		</tr>
		<tr>
			<td>部门:</td>
			<td><input id="kytc_system_user_add_dept_main_div" name="departmentId" data-options="required:true"></td>
			<td>角色:</td>
			<td><input id="kytc_system_user_add_title_main_div" name="titleId" data-options="required:true"></td>
		</tr>
		<tr>
			<td>备注:</td>
			<td colspan="3">
				<textarea name="remark" class="textbox" rows="3" cols="5" style="width:592px;height:80px;"></textarea>
			</td>
		</tr>
		<tr>
			<td>个性签名:</td>
			<td colspan="3">
				<textarea name="personalSign" class="textbox" rows="3" cols="5" style="width:592px;height:80px;"></textarea>
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