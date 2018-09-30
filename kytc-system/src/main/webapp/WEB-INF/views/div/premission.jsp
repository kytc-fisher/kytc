<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<tbody>
		<tr>
			<td>项目</td>
			<td>模块</td>
			<td>菜单</td>
			<td>操作</td>
			<td></td>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td rowspan="${item.length }">${item.projectName }<input name="project" data-value="${item.project }" class="chk_premission chk_label" type="checkbox"></td>
				<c:forEach var="module" items="${item.list }" varStatus="status">
					<c:if test="${status.first }">
						<td rowspan="${module.length }">${module.moduleName }<input name="module" data-value="${module.module }" data-project="${item.project }" class="chk_premission chk_label" type="checkbox"></td>
					</c:if>
					<c:if test="${!status.first }">
						<tr>
							<td rowspan="${module.length }">${module.moduleName }<input name="module" data-value="${module.module }" data-project="${item.project }" class="chk_premission chk_label" type="checkbox"></td>
						</tr>
					</c:if>
					<c:forEach var="menu" items="${module.list }" varStatus="menuStatus">
						<c:if test="${menuStatus.first }">
							<td rowspan="${menu.length }">
								<label>${menu.menuName }&nbsp;&nbsp;&nbsp;&nbsp;<input name="menu" data-module="${module.module }" data-value="${menu.menu }" class="chk_premission chk_label" type="checkbox">
								</label>
						</td>
						</c:if>
						<c:if test="${!menuStatus.first }">
							<tr>
								<td rowspan="${menu.length }">
									<label>${menu.menuName }&nbsp;&nbsp;&nbsp;&nbsp;<input name="menu" data-module="${module.module }" data-value="${menu.menu }" class="chk_premission chk_label" type="checkbox"></label>
								</td>
						</c:if>
						<c:forEach var="operator" items="${menu.list }" varStatus="operatorStatus">
							<c:if test="${operatorStatus.first }">
								<td>${operator.operateName }</td>
								<td>
									<input class="chk_premission" type="checkbox" data-menu="${menu.menu }" name="premission" data-value="${operator.premission }" <c:if test="${operator.isSelected }">checked="checked"</c:if>>
								</td>
								</tr>
							</c:if>
							<c:if test="${!operatorStatus.first }">
								<tr>
									<td>${operator.operateName }</td>
									<td>
										<input class="chk_premission" data-menu="${menu.menu }" type="checkbox" name="premission" data-value="${operator.premission }" <c:if test="${operator.isSelected }">checked="checked"</c:if>>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</c:forEach>
		</c:forEach>
	</tbody>
</table>