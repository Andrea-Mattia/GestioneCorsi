<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="cdn.html"%>
<meta charset="ISO-8859-1">
<title>Aggiungi corsista</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/convalida.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />

	<main>
	
		<div class="container add-corsista">

			<div class="page-header">
				<h3>Inserire i dati per aggiungere un corsista</h3>
			</div>
	
			<form
				action="/<%=application.getServletContextName()%>/aggiungiCorsista"
				method="post" class="form-horizontal" id="corsistaForm">
				<input type="hidden" name="codcorsista" value="0">
	
				<!-- ---------------------------------------------NOME -->
				<div class="form-group">
	
					<label class="col-md-1 control-label">Nome corsista</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" name="nome" placeholder="Nome..."
								class="form-control" id="nome">
						</div>
					</div>
	
					<div class="col-md-7 control-label" id="infoNome"></div>
				</div>
	
	
				<div class="form-group">
	
					<label class="col-md-1 control-label">Cognome corsista</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span> <input type="text" name="cognome" placeholder="Cognome..."
								class="form-control" id="cognome">
						</div>
					</div>
	
					<div class="col-md-7 control-label" id="infoCognome"></div>
				</div>
	
	
				<div class="form-group">
	
					<label class="col-md-1 control-label">Precedenti formativi</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-plus-sign"></i>
							</span>
							<div class="radio">
								<label>&nbsp;<input type="radio" name="precedentiFormativi"
									id="precedentiFormativi" value="1">SI
								</label>
							</div>
							<div class="radio">
								<label>&nbsp;<input type="radio" name="precedentiFormativi"
									id="precedentiFormativi" value="0" checked>NO
								</label>
							</div>
						</div>
					</div>
	
				<div class="row">
	
					<div class="col-md-4 col-md-offset-1">
						<button type="submit" class="btn btn-warning">
							Registrati&nbsp;<span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
	
				</div>
	
			</form>

		</div>
	
	</main>

	<footer class="footer">
		<%@include file="footer.html"%>
	</footer>
</body>
</html>