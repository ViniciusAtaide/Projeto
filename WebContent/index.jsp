<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="v" uri="MinhasTags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<v:index />
<title>TaskManager</title>
</head>
<body>
<div class="error_messages">${error_messages} </div>
	<div class="task_form">
	<form action="add.do" method="post">
		<input type="text" name="name" value="Add a new task" />
		<input type="submit" value="Enviar!" />	
	</form>
	</div>
	<div class="task_list">
	<form action="updatedelete.do" method="post">
		<c:forEach var="task" items="${tasks}">
			<input type="checkbox" name="tasks"  value="${task.done}" /> ${task.name}
		</c:forEach>
		<input type="submit" name="updatedelete" value="Mark selected as done" />
		<input type="submit" name="updatedelete" value="Delete selected" />		
	</form>	
	</div>
</body>
</html>