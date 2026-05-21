<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="form-box">

<h2>Register</h2>

<form action="register" method="post">

<input type="text" name="name" placeholder="Enter Name" required>

<input type="email" name="email" placeholder="Enter Email" required>

<input type="password" name="password" placeholder="Enter Password" required>

<select name="role">

    <option value="manager">Manager</option>

    <option value="employee">Employee</option>

</select>

<input type="submit" value="Register" class="btn">

</form>

</div>

</body>
</html>