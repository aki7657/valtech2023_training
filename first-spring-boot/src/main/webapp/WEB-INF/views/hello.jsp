<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <h1>Hello Spring MVC</h1>
<h2><%= request.getAttribute("name") %></h2> --%>
<h1>Hello ${name}</h1>
<a href="changePassword">Change Password</a>
</body>
</html>