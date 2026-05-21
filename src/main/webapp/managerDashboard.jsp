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
<title>Manager Dashboard</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="dashboard">

<h1>Manager Dashboard</h1>

<h3>Welcome : <%= u.getName() %></h3>

<a href="addProject.jsp" class="btn">Add Project</a>

<a href="viewProjects.jsp" class="btn">View Projects</a>

<a href="editProfile.jsp" class="btn">Edit Profile</a>

<a href="logout" class="btn logout">Logout</a>

</div>

</body>
</html>