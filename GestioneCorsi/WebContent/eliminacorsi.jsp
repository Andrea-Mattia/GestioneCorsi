<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%
if (session.getAttribute("username") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="cdn.html"%>
<meta charset="ISO-8859-1">
<title>Elimina corsi</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<main>
		<div class="container">
			<header class="page-header">
				<h3>Corsi</h3>
			</header>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Attivo</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
						Corso[] corsi = AdminFacade.getIstance().getCorsi();
						Calendar cal = Calendar.getInstance();
						Date data = cal.getTime();
						for (Corso c : corsi) {
						%>
						<tr>
							<td><%=c.getNomeCorso()%></td>
							<td>
							<%= (c.getDataFine()).before(data) ? "Terminato" : "Disponibile" %>
							<%= ((c.getDataInizio()).before(data) & (c.getDataFine()).after(data)) ? "/ Attivo" : "" %></td>
							<td>
								<form
									action="/<%=application.getServletContextName()%>/rimuoviCorso?id=<%=c.getCodCorso()%>"
									method="post">
									<button type="submit" class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-trash"></span>
									</button>
								</form>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("login.jsp");
}
%>