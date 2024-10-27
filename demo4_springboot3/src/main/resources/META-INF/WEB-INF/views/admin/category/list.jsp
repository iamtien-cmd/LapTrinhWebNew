<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="/admin/categories/add"> Add category </a>

<c:if test ="${message!=null}">
    ${message}
    </c:if>
<table>
	<tr>
		<th>STT</th>
		<th>Image</th>
		<th>Categoryname</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${list}" var="cate" varStatus="stt">
		<tr>
			<td>${stt.index+1}</td>
			<td>${cate.images}</td>
			<td>${cate.name }</td>
			<td>${cate.status}</td>
			<td>
			<a href="/admin/categories/edit/${cate.id}"> Sửa </a>
			<a href="/admin/categories/delete/${cate.id}"> Xóa </a>
			</td>
		</tr>
	</c:forEach>
</table>
