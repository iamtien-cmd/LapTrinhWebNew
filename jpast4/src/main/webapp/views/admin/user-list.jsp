<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<table border = "1", width= 100%>
	<tr>
		<th>STT</th>
		<th>ID</th>
		<th>Avatar</th>
		<th>Create date</th>
		<th>Email</th>
		<th>Full name</th>
		<th>Password</th>
		<th>Phone</th>
		<th>Role ID</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${listuser}" var="us" varStatus="STT">
		<tr >
			<td>${STT.index+1 }</td>
			<td>${us.id}</td>
			<td><c:if test="${us.avatar.substring(0,5) != 'https' }">
					<c:url value="/image?fname=${us.avatar }" var="imgUrl"></c:url>
				</c:if> <c:if test="${us.avatar.substring(0,5) == 'https' }">
					<c:url value="${us.avatar }" var="imgUrl"></c:url>
				</c:if> <img height="150" width="200" src="${imgUrl}" /></td>

			<td>${us.createDate}</td>
			<td>${us.email}</td>
			<td>${us.fullName}</td>
			<td>${us.passWord}</td>
			<td>${us.phone}</td>
			<td>${us.roleid}</td>
	
			<td><c:if test="${us.status == true}">
					<span>Đang hoạt động</span>
				</c:if> <c:if test="${us.status != true}">
					<span>Khoá</span>
				</c:if></td>
			<td><a
				href="<c:url value="/admin/user/update?id=${us.id }"/>"
				class="center">Sửa </a> | <a
				href="<c:url value="/admin/user/delete?id=${us.id}"/>"
				class="center">Xóa </a></
		</tr>
	</c:forEach>

</table>