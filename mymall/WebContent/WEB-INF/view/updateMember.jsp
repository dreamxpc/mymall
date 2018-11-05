<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateMember</title>
</head>
<body>
	<h2>updateMyProfile</h2>
	<form
		action="${pageContext.request.contextPath}/UpdateMemberController"
		method="post">
		ID : <input type="text" name="id" value="${member.getId()}" readonly><br>
		Password : <input type="password" name="pw" value="${member.getPw()}"><br>
		Level : <select name="level">
			<c:choose>
				<c:when test="${member.getLevel() == 1}">
					<option value="1" selected="selected">Admin</option>
					<option value="0">Guest</option>
				</c:when>
				<c:otherwise>
					<option value="1">Admin</option>
					<option value="0" selected="selected">Guest</option>
				</c:otherwise>
			</c:choose>
		</select><br> <input type="hidden" name="no" value="${member.getNo()}">
		<button type="submit">submit</button>
	</form>
</body>
</html>
