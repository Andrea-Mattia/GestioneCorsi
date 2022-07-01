<%
	if (session.getAttribute("username") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cdn.html"%>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@ include file="nav.jsp"%>

	<main class="home-button">
		
			<a href="aggiungicorsista.jsp">
				<button type="submit" class="btn btn-info my-btn">Inserisci<br>corsista</button>
			</a>
			<a href="report.jsp">
				<button type="submit" class="btn btn-default my-btn">Statistiche</button>
			</a>
			<a href="home.jsp">
				<button type="submit" class="btn btn-danger my-btn">Elimina<br>corsi</button>
			</a>
	</main>

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