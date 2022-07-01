<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cdn.html"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Error 404</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<main>
		<div class="container">
			<div class="page-header">
				<h3>Pagina non trovata</h3>
			</div>
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3>Impossibile trovare la risorsa richiesta</h3>
				</div>
				<div class="panel-body">
					<p>Siamo spiacenti del disagio, risolveremo al più presto</p>
					<p>
						Inviaci una segnalazione:&nbsp; <a href="mailto:admin@betacom.it">Email
							Amministratore</a>
					<br>
					<input type="button" class="btn btn-warning" value="Torna alla pagina precedente"
						onclick="window.history.back()" />
	
				</div>
			</div>
		</div>
	</main>
	<footer class="footer"><%@ include file="footer.html"%></footer>
</body>
</html>