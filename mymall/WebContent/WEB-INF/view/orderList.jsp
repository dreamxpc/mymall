<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>orderList</title>
</head>
<body>
	<h1>Order List</h1>
	<table border="1">
		<tr>
			<th>OrderNo</th>
			<th>OrderedBy</th>
			<th>OrderDate</th>
			<th>PCode</th>
			<th>PName</th>
			<th>Price</th>
		</tr>
		<c:forEach var="orderList" items="${orderList}" varStatus="status">
			<tr>
				<td>${orderList.get("no")}</td>
				<td>${orderList.get("id")}</td>
				<td>${orderList.get("order_date")}</td>
				<td>${orderList.get("item_no")}</td>
				<td>${orderList.get("name")}</td>
				<td>${orderList.get("price")}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>