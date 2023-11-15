<%@page import="com.valtech.training.firstspringboot.model.OrderModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	OrderModel orderModel = (OrderModel) request.getAttribute("order");
	%>
	<form method="post" action="save?id=<%= orderModel.getId()%>">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" disabled="disabled" name="id"
					value="<%=orderModel.getId()%>" /></td>
			</tr>
			<tr>
				<td>Item</td>
				<td><input type="text" name="item"
					value="<%=orderModel.getItem()%>" /></td>
			</tr>
			<tr>
				<td>ItemCount</td>
				<td><input type="text" name="itemCount"
					value="<%=orderModel.getItemCount()%>" /></td>
			</tr>
			<tr>
				<td>ItemDescription</td>
				<td><input type="text" name="itemDescription"
					value="<%=orderModel.getItemDescription()%>" /></td>
			</tr>
			<tr>
				<td>OrderDate</td>
				<td><input type="text" name="orderDate"
					value="<%=orderModel.getOrderDate()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Create" /> <input type="submit" name="cancel"
					value="Cancel" /></td>
			</tr>
		</table>
	</form>
</body>
</html>