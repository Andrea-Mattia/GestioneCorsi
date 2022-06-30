<%
	if(session.getAttribute("username") == null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="cdn.html"%>
	<meta charset="ISO-8859-1">
	<title>Login ammistratore</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<main>
		<div class="container">
			<div class="page-header">
				<h3>Inserire i dati per il login amministratore</h3>
			</div>
			<form action="/<%= application.getServletContextName() %>/controllo" method="POST" class="form-horizontal">
			
				<div class="form-group">
					<label class="col-md-1 control-label">Codice</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-log-in"></i>
							</span>
						<input type="text" name="username" placeholder="Codice Amministratore..." class="form-control">
						</div>
					</div>	
				</div>
				
				<!-- -------------------------PASSWORD -->
				<div class="form-group">
					<label class="col-md-1 control-label">Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</span>
						<input type="password" name="password" placeholder="Password..." maxlength="15" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-1">
						<button type="submit" class="btn btn-warning">
							Login
						</button>
					</div>
				</div>
			</form>
		</div>
	</main>
</body>
<footer class="footer"><%@include file="footer.html" %></footer>
</html>
<%
	} else {
		response.sendRedirect("home.jsp");
	}
%>