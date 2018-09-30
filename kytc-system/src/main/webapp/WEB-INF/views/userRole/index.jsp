<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/userRole/index.js"></script>
<style type="text/css">
.left_role{width:49.5%;float:left;}
.left_role label{display:block;height:30px;line-height:30px;border-radius:5px;border-bottom: 1px solid #bbb;
    background: -webkit-linear-gradient(top,#ffffff 0,#e6e6e6 100%);
    background: -moz-linear-gradient(top,#ffffff 0,#e6e6e6 100%);
    background: -o-linear-gradient(top,#ffffff 0,#e6e6e6 100%);
    background: linear-gradient(to bottom,#ffffff 0,#e6e6e6 100%);}
.left_role label input{width:20px;height:20px;vertical-align: middle;margin-bottom: 2px;}
.line_role{width:1%;float:left;background-color:#e6e6e6;height:100%;}
.active{background: linear-gradient(to bottom,green 0,#0081c2 100%) !important;
background: -webkit-linear-gradient(to bottom,green 0,#0081c2 100%) !important;
    background: -moz-linear-gradient(to bottom,green 0,#0081c2 100%) !important;
    background: -o-linear-gradient(to bottom,green 0,#0081c2 100%) !important;}
.left_role span,.right_role span{width: 100%;text-align: center;display: block;background-color: #e6e6e6;height: 30px;line-height: 30px;font-size: 18px;}
.right_role{width:49.5%;float:left;}
.right_role em{display:block;width:100%;height:30px;line-height:30px;}
.right_role em i{background-image:url(/system/easyui/themes/icons/delete.png);width: 16px;
    height: 16px;
    display: block;float:left;cursor:pointer;}
.right_role em u{float:left;}
</style>
<div id="kytc_system_user_role_main_div" style="width:100%;height:100%;">
	<input type="hidden" name="userId" value="${userId }">
	<div class="left_role">
		<span>部门角色</span>
		<c:forEach items="${data.role }" var="item">
			<label data-id="${item.id }" data-name="${item.roleName }" <c:if test="${item.isSelected }">class="active"</c:if>><input type="checkbox" name="check" <c:if test="${item.isSelected }">checked="checked"</c:if>/>&nbsp;&nbsp;&nbsp;${item.roleName }</label>
		</c:forEach>
	</div>
	<div class="line_role"></div>
	<div class="right_role">
		<span>已选角色</span>
		<c:forEach items="${data.list }" var="item">
			<em data-id="${item.roleId }" data-name="${item.roleName }"><u>${item.roleName }</u><i></i></em>
		</c:forEach>
	</div>
</div>