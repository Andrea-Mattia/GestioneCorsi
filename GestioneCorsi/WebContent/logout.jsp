<%
	if(session.getAttribute("username") != null) {
		session.invalidate();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cdn.html" %>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />

	<main>
		<div class="container">
		
			<div class="page-header">
				<h3>Logout</h3>
			</div>
			
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3>Hai appena effettuato il logout</h3>
				</div>
				
				<div class="panel-body">
					<p>Per procedere con la gestione dei corsi effettuare nuovamente l'accesso</p>
					<p><a href="login.jsp">Login</a></p>
				</div>
			</div>
		
		</div>
	</main>
	
	<footer class="footer">
		<%@ include file="footer.html" %>
	</footer>
	
</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>