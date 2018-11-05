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
	<h2>addMember Form</h2>
	<form action="${pageContext.request.contextPath}/AddMemberController"
		method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pw"></td>
			<tr>
				<td>Level</td>
				<td><select name="level">
						<option value="1">Admin</option>
						<option value="0">Guest</option>
				</select></td>
			<tr>
				<td><button type="submit">submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>