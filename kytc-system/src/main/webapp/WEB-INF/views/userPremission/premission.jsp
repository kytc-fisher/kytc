<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/userPremission/index.js"></script>
<div id="kytc_system_user_premission_index_main_div" style="width:100%;height:100%;" class="premission_list">
	<input type="hidden" name="id" value="${id }">
	<jsp:include page="../div/premission.jsp"></jsp:include>
</div>