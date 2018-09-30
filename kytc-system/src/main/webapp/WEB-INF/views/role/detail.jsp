<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/role/detail.js"></script>
<div id="kytc_system_role_detail_main_div" style="width:100%;height:100%;">
	<table class="detail_table">
		<tbody>
			<tr>
				<td>角色名称:</td>
				<td>
					${result.data.roleName }
				</td>
				<td>所属部门:</td>
				<td>${result.data.departmentName }</td>
			</tr>
			<tr>
				<td>角色类型:</td>
				<td>
					<c:if test="${result.data.type==1 }">共享角色</c:if>
					<c:if test="${result.data.type==2 }">部门角色</c:if>
				</td>
				<td>排序号:</td>
				<td>
					${result.data.sortNum }
				</td>
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
				<td>创建时间:</td>
				<td colspan="3">
					${result.data.operatorName }
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
	<c:if test="${result.data.list!=null }">
		<div style="width:100%;height:310px;overflow-y:auto;" class="premission_list">
			<table>
				<tbody>
					<tr>
						<td>项目</td>
						<td>模块</td>
						<td>菜单</td>
						<td>操作</td>
					</tr>
					<c:forEach var="item" items="${result.data.list }">
						<tr>
							<td rowspan="${item.length }">${item.projectName }</td>
							<c:forEach var="module" items="${item.list }" varStatus="status">
								<c:if test="${status.first }">
									<td rowspan="${module.length }">${module.moduleName }</td>
								</c:if>
								<c:if test="${!status.first }">
									<tr>
										<td rowspan="${module.length }">${module.moduleName }</td>
									</tr>
								</c:if>
								<c:forEach var="menu" items="${module.list }" varStatus="menuStatus">
									<c:if test="${menuStatus.first }">
										<td rowspan="${menu.length }">
											${menu.menuName }
										</td>
									</c:if>
									<c:if test="${!menuStatus.first }">
										<tr>
											<td rowspan="${menu.length }">
												${menu.menuName }
											</td>
									</c:if>
									<c:forEach var="operator" items="${menu.list }" varStatus="operatorStatus">
										<c:if test="${operatorStatus.first }">
											<td>${operator.operateName }</td>
											</tr>
										</c:if>
										<c:if test="${!operatorStatus.first }">
											<tr>
												<td>${operator.operateName }</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:forEach>
							</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</div>