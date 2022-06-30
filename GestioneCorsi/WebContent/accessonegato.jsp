<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cdn.html" %>
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />

	<main>
		<div class="container">
		
			<div class="page-header">
				<h3>Non puoi accedere a questa pagina</h3>
			</div>
			
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3>Risorsa non disponibile</h3>
				</div>
				
				<div class="panel-body">
					<p>Effettuare l'accesso</p>
					<p><a class="btn btn-warning" href="login.jsp">Login</a></p>
				</div>
			</div>
		
		</div>
	</main>
	
	<footer class="footer">
		<%@ include file="footer.html" %>
	</footer>
	
</body>
</html>