<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
welcome : Admin

<hr>

<%-- <c:if test="${not empty pageContext.request.userPrincipal}" >
<p> is Log-In</p>
</c:if>  

<c:if test="${empty pageContext.request.userPrincipal}" >
<p> is Log-Out</p>
</c:if> --%>

<sec:authorize access="isAuthenticated()">  <%-- 인증된 사용자인 경우 --%>
<p> Log-In</p>
</sec:authorize>
 
<sec:authorize access="!isAuthenticated()">  <%-- 인증된 사용자가 아닌 경우 --%>
<p> Log-Out</p>
</sec:authorize>

<%-- USER ID : ${pageContext.request.userPrincipal.name }<br /> --%>
USER ID : <sec:authentication property="name" /> <br />  <%-- 인증태그 <sec:authentication> : propery -접근 권한이 설정된 현재 authentication 객체 이름 --%>
 
<c:url value="/logout" var="logoutUrl" />
<a href="${logoutUrl}">Log Out</a><br />

</body>
</html>