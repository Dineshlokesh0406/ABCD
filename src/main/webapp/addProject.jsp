<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Project</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="form-box">

<h2>Add Project</h2>

<form action="addProject" method="post">

<input type="text" name="projectName"
placeholder="Project Name" required>

<textarea name="description"
placeholder="Project Description"></textarea>

<select name="status">

    <option>Pending</option>
    <option>In Progress</option>
    <option>Completed</option>

</select>

<input type="submit" value="Add Project" class="btn">

</form>

</div>

</body>
</html>