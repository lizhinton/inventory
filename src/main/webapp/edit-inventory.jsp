<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Item</title>
</head>
<body>
	<form action="editInventoryServlet" method="post">
		product: <input type="text" name="productName" value="${itemToEdit.productName}">
		price: <input type="text" name="price" value="${itemToEdit.price}">
		Quantity<input type="text" name="qty" value="${itemToEdit.quantity}">
		<input type="hidden" name="id" value="${itemToEdit.id}"> <input
			type="submit" value="Save Item">
	</form>
	<a href="index.html">Add Item</a>
</body>
</html>