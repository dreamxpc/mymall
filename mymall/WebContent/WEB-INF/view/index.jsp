<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<c:if test="${loginMember != null}">
		Welcome ${loginMember.getId()}
		<a href="${pageContext.request.contextPath}/GetMemberController">UpdateMyProfile</a>
		<a href="${pageContext.request.contextPath}/LogoutController">Logout</a>
		<a href="${pageContext.request.contextPath}/itemListController">ItemList</a>
		<a href="${pageContext.request.contextPath}/OrderListController">OrderList</a>
		<a href="${pageContext.request.contextPath}/DeleteMemberController">DeleteMember</a>
	</c:if>
	<c:if test="${loginMember == null}">
		<a href="${pageContext.request.contextPath}/LoginController">Login</a>
		<a href="${pageContext.request.contextPath}/AddMemberController">SignUp</a>
	</c:if>
</body>
</html>