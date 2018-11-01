<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getMember.jsp</title>
</head>
<body>
	${member.getLevel()==0} ${member.getLevel()==1}
	<table border="1">
		<tr>
			<td>NO</td>
			<td>${member.getNo()}</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>${member.getId()}</td>
		</tr>
		<tr>
			<td>LEVEL</td>
			<td>
			<c:choose>
				<td><c:when test="${member.getLevel() == 1}">
					ADMIN
				</c:when> <c:otherwise>
					GUEST
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>