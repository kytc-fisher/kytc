<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dictionary/update.js"></script>
<div id="kytc_system_dictionary_update_main_div" style="width:100%;height:100%;">
	<table class="detail_small_table">
		<tbody>
			<tr>
				<td>类型:</td>
				<td>
					${result.data.typeName }
					<input type="hidden" value="${result.data.type }" name="type"/>
					<input type="hidden" value="${result.data.id }" name="id"/>
				</td>
				<td>编码:</td>
				<td>
					<input class="easyui-validatebox easyui-textbox" value="${result.data.code }" name="code" data-options="required:true">
				</td>
			</tr>
			<tr>
				<td>名称:</td>
				<td>
					<input class="easyui-validatebox easyui-textbox" value="${result.data.name }" name="name" data-options="required:true">
				</td>
				<td>排序号:</td>
				<td>
					<input value="${result.data.sortNum }" class="easyui-numberspinner easyui-validatebox" name="sortNum" data-options="increment:1,min:1,required:true">
				</td>
			</tr>
			<tr>
				<td>上级类型:</td>
				<td><input id="kytc_system_dictionary_update_main_div_parent_type" name="parentType" data-original="${result.data.parentType }"></td>
				<td>上级编码:</td>
				<td><input id="kytc_system_dictionary_update_main_div_parent_code" class="easyui-combobox" name="parentCode" data-original="${result.data.parentCode }"></td>
			</tr>
			<tr>
				<td>备注:</td>
				<td colspan="3">
					<textarea name="remark" class="textbox" rows="3" cols="5" style="width:592px;height:80px;">${result.data.remark }</textarea>
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