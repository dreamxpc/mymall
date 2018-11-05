<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login Form</h1>
	<a href="${pageContext.request.contextPath}/AddMemberController">SignUp</a>
	<form action="${pageContext.request.contextPath}/LoginController"
		method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>
					<button type="submit">login</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>