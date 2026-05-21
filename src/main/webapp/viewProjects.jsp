<%@ page import="java.util.*" %>
<%@ page import="com.dao.ProjectDAO" %>
<%@ page import="com.model.Project" %>
<%@ page import="com.model.User" %>

<%

User u = (User)session.getAttribute("user");

if(u == null){

    response.sendRedirect("login.jsp");
}

ProjectDAO dao = new ProjectDAO();

List<Project> list = dao.getAllProjects();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Projects</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="table-box">

<h2>Project List</h2>

<table>

<tr>

<th>ID</th>
<th>Name</th>
<th>Description</th>
<th>Status</th>

<%
if(u.getRole().equals("manager")){
%>

<th>Action</th>

<%
}
%>

</tr>

<%
for(Project p : list){
%>

<tr>

<td><%= p.getProjectId() %></td>

<td><%= p.getProjectName() %></td>

<td><%= p.getDescription() %></td>

<td><%= p.getStatus() %></td>

<%
if(u.getRole().equals("manager")){
%>

<td>

<a href="deleteProject?id=<%= p.getProjectId() %>"
class="delete-btn">

Delete

</a>

</td>

<%
}
%>

</tr>

<%
}
%>

</table>

<br>

<a href="managerDashboard.jsp" class="btn">Back</a>

</div>

</body>
</html>