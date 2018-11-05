<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<h1>ItemList</h1>
	<table border="1">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Price</th>
			<th>Order</th>
		</tr>
		<c:set var="num" value="0" />
		<c:forEach var="item" items="${itemlist}" varStatus="status">
			<tr>
				<td>${item.get("no")}</td>
				<td>${item.get("name")}</td>
				<td>${item.get("price")}</td>
				<td><a
					href="${pageContext.request.contextPath}/OrderController?itemNo=${item.get("no")}">Order</a></td>
			</tr>
		</c:forEach>
	</table>
	<div></div>
</body>
</html>