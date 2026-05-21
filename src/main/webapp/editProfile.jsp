<%@ page import="com.model.User" %>

<%
User u = (User)session.getAttribute("user");

if(u == null){

    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="form-box">

<h2>Edit Profile</h2>

<form action="editProfile" method="post">

<input type="hidden" name="id"
value="<%= u.getId() %>">

<input type="text" name="name"
value="<%= u.getName() %>">

<input type="email" name="email"
value="<%= u.getEmail() %>">

<input type="password" name="password"
placeholder="Enter New Password">

<input type="submit" value="Update Profile"
class="btn">

</form>

</div>

</body>
</html>