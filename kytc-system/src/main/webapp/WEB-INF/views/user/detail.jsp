<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/detail.js"></script>
<div id="kytc_system_user_detail_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
		<tr>
			<td>用户昵称:</td>
			<td>${result.data.nickName }</td>
			<td colspan="2" rowspan="5">
				<img alt="" src="${result.data.headPicture }" style="width:200px;height:200px;" name="preview"><br>
			</td>
		</tr>
		<tr>
			<td>真实名字:</td>
			<td>${result.data.realName }</td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>
				<c:choose>
					<c:when test="${result.data.sex==0 }">未知的性别</c:when>
					<c:when test="${result.data.sex==1 }">男性</c:when>
					<c:when test="${result.data.sex==2 }">女性</c:when>
					<c:when test="${result.data.sex==5 }">女性改（变）为男性</c:when>
					<c:when test="${result.data.sex==6 }">男性改（变）为女性</c:when>
					<c:when test="${result.data.sex==9 }">未说明的性别</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>生日:</td>
			<td>
				<fmt:formatDate value="${result.data.birthday }" pattern="yyyy-MM-dd" />
			</td>
		</tr>
		<tr>
			<td>身份证号:</td>
			<td>${result.data.idCard }</td>
		</tr>
		<tr>
			<td>电子邮箱:</td>
			<td>${result.data.email }</td>
			<td>手机号:</td>
			<td>${result.data.phone }</td>
		</tr>
		<tr>
			<td>部门:</td>
			<td>${result.data.departmentName }</td>
			<td>角色:</td>
			<td>${result.data.titleName }</td>
		</tr>
		<tr>
			<td>备注:</td>
			<td colspan="3">
				${result.data.remark }
			</td>
		</tr>
		<tr>
			<td>个性签名:</td>
			<td colspan="3">
				${result.data.personalSign }
			</td>
		</tr>
		<tr>
			<td>最后操作人ID:</td>
			<td>${result.data.operatorId }</td>
			<td>最后操作人:</td>
			<td>${result.data.operatorName }</td>
		</tr>
		<tr>
			<td>创建时间:</td>
			<td><fmt:formatDate value="${result.data.createTime }" pattern="yyyy-MM-dd  HH:mm:ss" /></td>
			<td>最后操作时间:</td>
			<td><fmt:formatDate value="${result.data.lastUpdateTime }" pattern="yyyy-MM-dd  HH:mm:ss" /></td>
		</tr>
		<tr>
			<td colspan="4">
				<div class="btn_div">
					<a name="close" style="margin-top:10px;" class="easyui-linkbutton" data-options="iconCls:'icon-close'">关闭</a>
				</div>
			</td>
		</tr>
		</tbody>
	</table>
</div>