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
	DeleteMember
	<h3>Are you sure want to delete?</h3>
	Enter the password for delete
	<form
		action="${pageContext.request.contextPath}/DeleteMemberController"
		method="post">
		<input type="password" name="pw">
		<button type="submit">submit</button>
	</form>
</body>
</html>