<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5 style="color: red">${message}</h5>
	<form action="changePassword" method="post">
		<table>
			<tr>
				<td>Old Password</td>
				<td><input name="oldPassword" type="password"></td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input name="newPassword" type="password"></td>
			</tr>
			<tr>
				<td>Confirm New Password</td>
				<td><input name="confirmNewPassword" type="password"></td>
			</tr>
			<tr colspan="2">
				<td><input type="submit" name="submit" value="Change Password">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>