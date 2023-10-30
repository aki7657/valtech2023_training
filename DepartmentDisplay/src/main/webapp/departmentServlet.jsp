<%@page import="departmentDisplay.DepartmentD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department and Employee Details</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
    }

    .container {
        margin: 20px;
    }

    table {
        background-color: #fff;
        border: 1px solid #ccc;
        border-collapse: collapse;
        width: 100%;
        max-width: 800px;
        margin: 0 auto;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #007BFF;
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #d0e4f7;
    }

    input[type="submit"] {
        background-color: #007BFF;
        color: #fff;
        border: none;
        padding: 8px 15px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
	<%
	DepartmentD dept = (DepartmentD) session.getAttribute("dept");
	%>
	<table class="table table-bordered">
		<tr>
			<td>Department Id:</td>
			<td><%=dept.getDeptId()%></td>
		</tr>
		<tr>
			<td>Department Name:</td>
			<td><%=dept.getDeptName()%></td>
		</tr>
		<tr>
			<td>Department Location:</td>
			<td><%=dept.getDeptLoc()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="dispEmpbyDept" method="post">
					<input type="submit" name="submit" value="First" /> <input
						type="submit" name="submit" value="Previous" /> <input
						type="submit" name="submit" value="Next" /> <input type="submit"
						name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>EXPERIENCE</th>
				<th>SENIORITY</th>
				<th>SALARY</th>
				<th>DEPTID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${emps}">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.age}" /></td>
					<td><c:out value="${employee.experience}" /></td>
					<td><c:out value="${employee.seniority}" /></td>
					<td><c:out value="${employee.salary}" /></td>
					<td><c:out value="${employee.deptId}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
