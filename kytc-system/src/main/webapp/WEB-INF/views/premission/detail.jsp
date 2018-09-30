<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/premission/detail.js"></script>
<div id="kytc_system_premission_detail_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
			<tr>
				<td>项目:</td>
				<td>
					${result.data.projectName }
				</td>
				<td>模块:</td>
				<td>${result.data.moduleName }</td>
			</tr>
			<tr>
				<td>菜单:</td>
				<td>${result.data.menuName }</td>
				<td>操作:</td>
				<td>
					${result.data.operateName }
				</td>
			</tr>
			<tr>
				<td>权限:</td>
				<td>${result.data.premission }</td>
				<td>最后操作人:</td>
				<td>${result.data.operatorName }</td>
			</tr>
			<tr>
				<td>创建时间:</td>
				<td>
					<fmt:formatDate value="${result.data.createTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
				</td>
				<td>最后更新时间:</td>
				<td>
					<fmt:formatDate value="${result.data.lastUpdateTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
				</td>
			</tr>
			<tr>
				<td>描述:</td>
				<td colspan="3">
					${result.data.description }
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="btn_div">
						<a name="close" class="easyui-linkbutton" data-options="iconCls:'icon-close'">关闭</a>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>