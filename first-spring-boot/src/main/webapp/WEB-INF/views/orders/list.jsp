<%@page import="com.valtech.training.firstspringboot.model.OrderModel"%>
<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>List of orders</h3>
	<%
	List<OrderModel> orders = (List<OrderModel>) request.getAttribute("orders");
	%>
	<table>
		<tr>
			<th>Id</th>
			<th>Item</th>
			<th>ItemCount</th>
			<th>ItemDescription</th>
			<th>OrderDate</th>
			<th>Actions</th>
		</tr>
		
		<!-- 
		JSTL core library
		<c:forEach>
		 -->
		
		<%
		for (OrderModel o : orders) {
			request.setAttribute("o", o);
		%>

		<tr>
			<%-- <td><%=o.getId()%></td>
			<td><%=o.getItem()%></td>
			<td><%=o.getItemCount()%></td>
			<td><%=o.getItemDescription()%></td>
			<td><%=o.getOrderDate()%></td> --%>
			<td>${o.id }</td>
			<td>${o.item }</td>
			<td>${o.itemCount }</td>
			<td>${o.itemDescription }</td>
			<td>${o.orderDate }</td>
			<td>
			<%-- <a href="delete?id=<%=o.getId()%>">Delete</a>
			<a href="edit?id=<%=o.getId()%>">Edit</a> --%>
			<a href="delete?id=${o.id }">Delete</a>
			<a href="edit?id=${o.id }">Edit</a>
			<!-- Setters and getters are called properties -->
			</td>
		</tr>

		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="6" align="right">
					<form action="new" method="get">
						<input type="submit" name="submit" value="New Order">
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>