<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sitemesh" uri="http://sitemesh.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Page Title</title>
</head>
<body>
    <div>
        <%@ include file="../../commons/admin/header.jsp" %>
        <div>
            <sitemesh:write property="body"/>
        </div>
        <%@ include file="../../commons/admin/footer.jsp" %>
    </div>
</body>
</html>
