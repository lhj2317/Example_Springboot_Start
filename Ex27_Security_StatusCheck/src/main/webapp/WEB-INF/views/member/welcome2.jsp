<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
welcome : Member

<hr>

<c:if test="${not empty pageContext.request.userPrincipal}" >
<p> is Log-In</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal}" >
<p> is Log-Out</p>
</c:if>

USER ID : ${pageContext.request.userPrincipal.name }<br />
<a href="/logout">Log Out</a><br />

</body>
</html>