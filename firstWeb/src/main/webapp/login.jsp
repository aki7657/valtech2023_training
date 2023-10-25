<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<!-- bootstrap -->
<div class="row">
<div class="col form-floating mb-3 mt-3">
<form action="login" method="post">
<label for ="name">Name:</label>
<input name = "name" type = "text" class ="form-control" placeholder="Enter your username" /><br/>
</div>
<div class="col form-floating mb-3 mt-3">
<label for ="pass">Password:</label>
<input name = "pass" type = "password"/ class ="form-control" placeholder="Enter password" ><br/>
</div>
<br/>
</div>
<input name="submit" type="submit" value="login" class="btn btn-success btn-sm btn-outline-success"/><br/>
</form>
<%= request.getAttribute("message") %>
</body>
</html>