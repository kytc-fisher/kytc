<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dictionaryType/update.js"></script>
<div id="kytc_system_dictionary_type_update_main_div" style="width:100%;height:100%;">
	<table class="detail_small_table">
		<tbody>
		<tr>
			<td>编码:</td>
			<td>
				${result.data.code }
				<input type="hidden" name="code" value="${result.data.code }"/>
				<input type="hidden" name="id" value="${result.data.id }"/>
			</td>
		</tr>
		<tr>
			<td>名称:</td>
			<td><input class="easyui-validatebox easyui-textbox" value="${result.data.name }" name="name" data-options="required:true"></td>
		</tr>
		<tr>
			<td>排序号:</td>
			<td>
				<input class="easyui-numberspinner easyui-validatebox" value="${result.data.sortNum }" name="sortNum" data-options="increment:1,min:1,required:true">
			</td>
		</tr>
		<tr>
			<td>备注:</td>
			<td>
				<textarea name="remark" class="textbox" rows="3" cols="5" style="width:352px;height:80px;">${result.data.remark }</textarea>
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