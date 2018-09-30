<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/title/update.js"></script>
<div id="kytc_system_title_update_main_div" style="width:100%;height:100%;">
	<table class="detail_small_table">
		<tbody>
		<tr>
			<td>职务名称:</td>
			<td>
				${result.data.name }
				<input type="hidden" value="${result.data.name }" name="name">
				<input type="hidden" value="${result.data.id }" name="id">
			</td>
		</tr>
		<tr>
			<td>上级职务:</td>
			<td><input class="easyui-textbox" id="kytc_system_title_update_parent_main_div" data-original="${result.data.parentId }" name="parentId" style="width:150px;height:32px"></td>
		</tr>
		<tr>
			<td>排序号:</td>
			<td>
				<input class="easyui-numberspinner" name="sortNum" value="${result.data.sortNum }" data-options="increment:1,min:1"></input>
			</td>
		</tr>
		<tr>
			<td>备注:</td>
			<td>
				<textarea class="textbox" name="remark" rows="3" cols="5" style="width:292px;height:80px;">
					${result.data.remark }
				</textarea>
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