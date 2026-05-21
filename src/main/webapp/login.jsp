<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="form-box">

<h2>Login</h2>

<form action="login" method="post">

<input type="email" name="email" placeholder="Enter Email" required>

<input type="password" name="password" placeholder="Enter Password" required>

<select name="role">

    <option value="manager">Manager</option>

    <option value="employee">Employee</option>

</select>

<input type="submit" value="Login" class="btn">

</form>

<p>
<a href="register.jsp">New User? Register</a>
</p>

</div>

</body>
</html>