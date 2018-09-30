<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dictionaryType/detail.js"></script>
<div id="kytc_system_dictionary_type_detail_main_div" style="width:100%;height:100%;">
	<table class="detail_small_table">
		<tbody>
		<tr>
			<td>编码:</td>
			<td>
				${result.data.code }
			</td>
		</tr>
		<tr>
			<td>名称:</td>
			<td>${result.data.name }</td>
		</tr>
		<tr>
			<td>排序号:</td>
			<td>
				${result.data.sortNum }
			</td>
		</tr>
		<tr>
			<td>备注:</td>
			<td>
				${result.data.remark }
			</td>
		</tr>
		<tr>
			<td>创建时间:</td>
			<td>
				<fmt:formatDate value="${result.data.createTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
			</td>
		</tr>
		<tr>
			<td>最后操作人:</td>
			<td>
				${result.data.operatorName }
			</td>
		</tr>
		<tr>
			<td>最后更新时间:</td>
			<td>
				<fmt:formatDate value="${result.data.lastUpdateTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
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