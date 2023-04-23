<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Do.StudentDAo"%>
<%@ page import="modal.Student"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>


	<%!StudentDAo dao;

	public void jspInit() {

		dao = new StudentDAo();

	}%>

	<%
	String url = application.getInitParameter("url");
	String username = application.getInitParameter("username");
	String password = application.getInitParameter("password");
	%>


	<%
	List<Student> list = dao.getAllStudent(url, username, password);
	Iterator<Student> itr = list.iterator();

	application.setAttribute("list", list);
	%>

	<br><h3><b> --- STUDENT DATA TABLE ---</b></h3><br><br>

	<div class="container">
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Marks</th>
				<th>DELETE</th>
				<th>UPDATE</th>
			</tr>

			<c:forEach var="st" items="${applicationScope.list }">
				<tr>
					<td><c:out value="${st.id}"></c:out></td>
					<td><c:out value="${st.name}"></c:out></td>
					<td><c:out value="${st.marks}"></c:out></td>
					<td><a
						href="${pageContext.request.contextPath}/Delete?id=${st.id}">DELETE</a></td>
					<td><a
						href="${pageContext.request.contextPath}/UpdateServlet_1_?id=${st.id}">UPDATE</a></td>
				</tr>
			</c:forEach>

		</table>

	</div>


</body>
</html>