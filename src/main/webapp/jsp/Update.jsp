<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="orenge">
<h1 style="text-align: center;">---- Update Data ----</h1>


<form action="UpdateServlet" method="get">
<center>
<table>
	<tr>
		<td>Id :<input type="text" name="id" value="${requestScope.student.id}" readonly="readonly"><br></td>
	</tr>
	<tr>
		<td>Name :<input type="text" name="name"value="${ requestScope.student.name }"><br></td>
	</tr>
	
	<tr>
		<td>Marks :<input type="text" name="marks"value="${ requestScope.student.marks}"><br></td>
	</tr>
	<tr>
		<td><input type="submit" value="UpdateServlet"></td>
	</tr>
</table>
</center>


</body>
</html>