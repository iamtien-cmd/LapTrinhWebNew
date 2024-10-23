<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url value="/" var="URL"></c:url>

<!DOCTYPE html>

<html lang="en">
<%@ include file="../../commons/web/header.jsp" %>
<div>
    <sitemesh:write property ="body"/>
</div>

<%@ include file="../../commons/web/footer.jsp" %>