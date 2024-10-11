<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<form action="${pageContext.request.contextPath}/admin/user/update"
      method="post" enctype="multipart/form-data">
	<input type="text"
		id="id" name="id" value="${us.id}" hidden="hidden"><br>
	<label for="fname">full name:</label> <br> 
	<input type="text"
		id="fullname" name="fullname" value="${us.fullName}"><br>
	<label for="lname">Avatar:</label> <br>
	<c:if test="${us.avatar.substring(0,5)  != 'https'}">
		<c:url value="/image?fname=${us.avatar}" var="imgUrl"></c:url>
	</c:if>
	<c:if test="${us.avatar.substring(0,5)  == 'https'}">
		<c:url value="${us.avatar}" var="imgUrl"></c:url>
	</c:if>
	<img height="150" width="200" src="${imgUrl}" id="imagess" />
	<input
		type="file" onchange="chooseFile(this)" id="imagess" name="avatar"><br>
		
	<label for="createdate">Create date:</label> <br>
<input type="date" id="createdate" name="createdate" 
       value="${us.createDate != null ? us.createDate.toLocalDate() : ''}"><br>
		
	<label for="fname">Email:</label> <br> 
	<input type="text"
		id="email" name="email" value="${us.email}"><br>
		
	<label for="fname">Password:</label> <br> 
	<input type="text"
		id="password" name="password" value="${us.passWord}"><br>
		
	<label for="fname">Phone:</label> <br> 
	<input type="text"
		id="phone" name="phone" value="${us.phone}"><br>
		
	<label for="fname">Role ID:</label> <br> 
	<input type="text"
		id="roleid" name="roleid" value="${us.roleid}"><br>
		
		
	<p>Status:</p>
	<input type = "radio" id="ston" name="status" value="true" checked>
	<label for="html">Đang hoạt động</label><br>
	<input type = "radio" id="stoff" name="status" value="false">
	<label for="css">Khoá</label><br>
		<input type="submit" value="Update">
</form>

<!--  enctype="multipart/form-data" -->