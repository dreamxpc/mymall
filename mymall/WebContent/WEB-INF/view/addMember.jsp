<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember.jsp</title>
</head>
<body>
	<h1>addMember Form</h1>
	<form action="${pageContext.request.contextPath}/AddMemberController"
		method="post">
		<table border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" size="20"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="pw" size="20"></td>
			</tr>
			<tr>
				<td>LEVEL</td>
				<td><select name="level">
						<option value="1">ADMIN</option>
						<option value="0">GUEST</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">SUBMIT</button></td>
			</tr>
		</table>
	</form>
</body>
</html>