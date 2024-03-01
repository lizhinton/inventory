<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory</title>
</head>
<body>
	<form action="navigationServlet" method="post">
		<table>
			<thead>
				<tr>
					<th>Select</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.allInventory}" var="item">
					<tr>
						<td><input type="radio" name="id" value="${item.id}"></td>
						<td>${item.productName}</td>
						<td>${item.price}</td>
						<td>${item.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="edit" name="doThisToItem"> <input
			type="submit" value="delete" name="doThisToItem"> <input
			type="submit" value="add" name="doThisToItem">
	</form>
	<a href="index.html">Add Item</a>
</body>
</html>