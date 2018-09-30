<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/title/detail.js"></script>
<div id="kytc_system_title_detail_main_div" style="width:100%;height:100%;">
	<c:if test="${result.state }">
		<table class="detail_small_table">
			<tbody>
			<tr>
				<td>职务名称:</td>
				<td>${result.data.name }</td>
			</tr>
			<tr>
				<td>上级职务:</td>
				<td>${result.data.parentName }</td>
			</tr>
			<tr>
				<td>排序号:</td>
				<td>${result.data.sortNum }</td>
			</tr>
			<tr>
				<td>创建时间:</td>
				<td>
					<fmt:formatDate value="${result.data.createTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td>最后操作人:</td>
				<td>${result.data.operatorName }</td>
			</tr>
			<tr>
				<td>最后操作时间:</td>
				<td>
					<fmt:formatDate value="${result.data.lastUpdateTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td>备注:</td>
				<td>
					${result.data.remark }
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="btn_div">
						<a name="close" class="easyui-linkbutton" data-options="iconCls:'icon-close'">关闭</a>
					</div>
				</td>
			</tr>
			</tbody>
		</table>
	</c:if>
	<c:if test="${not result.state }">
		${result.reason }
	</c:if>
</div>