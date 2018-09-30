<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/department/detail.js"></script>
<div id="kytc_system_dept_detail_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
		<tr>
			<td>部门名称:</td>
			<td>${result.data.departmentName }</td>
			<td>部门简称:</td>
			<td>${result.data.shortName }</td>
		</tr>
		<tr>
			<td>英文名称:</td>
			<td>${result.data.englishName }</td>
			<td>建立时间:</td>
			<td><fmt:formatDate value="${result.data.establishTime }" pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td>上级部门:</td>
			<td>
				${result.data.parentName }
			</td>
			<td>部门领导:</td>
			<td>
				${result.data.leaderName }
			</td>
		</tr>
		<tr>
			<td>排序号:</td>
			<td>${result.data.sortNum }</td>
			<td>最后操作人:</td>
			<td>
				${result.data.operatorName }
			</td>
		</tr>
		<tr>
			<td>部门描述:</td>
			<td colspan="3">
				${result.data.description }
			</td>
		</tr>
		<tr>
			<td>创建时间:</td>
			<td>
				<fmt:formatDate value="${result.data.createTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
			</td>
			<td>最后操作时间:</td>
			<td>
				<fmt:formatDate value="${result.data.lastUpdateTime }" pattern="yyyy-MM-dd  HH:mm:ss" />
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