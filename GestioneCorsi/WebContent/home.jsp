<%
	if(session.getAttribute("username") != null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="cdn.html"%>
	<meta charset="ISO-8859-1">
	<title>Login ammistratore</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@ include file="nav.jsp"%>
	
	<table>
		<caption>User List</caption>
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Created</th>
				<th scope="col">Status</th>
				<th scope="col">Email</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td scope="row">Leonard Hofstadter</td>
				<td>07/06/2016</td>
				<td>Pending</td>
				<td>lhofstadter@caltech.edu</td>
			</tr>
			<tr>
				<td scope="row">Sheldon Cooper</td>
				<td>07/01/2016</td>
				<td>Active</td>
				<td>scooper@@caltech.edu</td>
			</tr>
			<tr>
				<td scope="row">Howard Wolowitz</td>
				<td>06/05/2016</td>
				<td>Inactive</td>
				<td>hwolowitz@caltech.edu</td>
			</tr>
			<tr>
				<td scope="row">Raj Koothrappali</td>
				<td>06/20/2016</td>
				<td>Active</td>
				<td>rkoothrappali@caltech.edu</td>
			</tr>
			<tr>
				<td scope="row">Penny</td>
				<td>07/06/2016</td>
				<td>Active</td>
				<td>penny@cheesecakefactory.com</td>
			</tr>
			<tr>
				<td scope="row">Bernadette Rostenkowski</td>
				<td>07/05/2016</td>
				<td>Pending</td>
				<td>brostenkowski@caltech.edu</td>
			</tr>
			<tr>
				<td scope="row">Amy Farrah Fowler</td>
				<td>07/05/2016</td>
				<td>Pending</td>
				<td>afowler@caltech.edu</td>
			</tr>
		</tbody>
	</table>

	<footer>
		<%@ include file="footer.html"%>
	</footer>
</body>
</html>

<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>