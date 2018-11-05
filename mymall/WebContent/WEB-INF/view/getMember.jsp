<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>Level</th>
		</tr>
		<tr>
			<th>${member.getNo()}</th>
			<th>${member.getId()}</th>
			<c:choose>
				<c:when test="${member.getLevel() == 1}">
					<th>Admin</th>
				</c:when>
				<c:otherwise>
					<th>Guest</th>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/UpdateMemberController">UpdateMyProfile</a>
	<a href="${pageContext.request.contextPath}/DeleteMemberController">DeleteMember</a>
	<a href="${pageContext.request.contextPath}/IndexController">Back</a>
</body>
</html>