<%
	if (session.getAttribute("username") != null) {
%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="it.betacom.businesscomponent.utilities.ReportUtility"%>
<%@page import="java.util.Vector"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistiche</title>
<%@ include file="cdn.html"%>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<%@ include file="nav.jsp"%>
	</header>
	<main>
		<div class="container">

			<div class="my-page-header">
				<h3>Corsi più frequentati</h3>
				<h3>Docenti di punta</h3>
			</div>

			<div class="popular-courses-container">
			
				<%
					ReportUtility rpu = new ReportUtility();
					Vector<String[]> corsi;
						
				%>
				<div>
					<canvas id="myChart" style="height: 300px;"></canvas>
				</div>
				
				<div class="table-responsive">
					<table class="table table-hover teacher-table">
						<thead>
							<tr>
								<th>Codice corso</th>
								<th>Nome docente</th>
								<th>Cognome docente</th>
							</tr>
						</thead>
						<tbody>
							<%
								corsi = rpu.getCorsiDocenti();
								for(String[] dati: corsi) {
									
							%>
							<tr>
								<td><%= dati[2] %></td>
								<td><%= dati[0] %></td>
								<td><%= dati[1] %></td>
							</tr>
							
							<% } %>
						</tbody>
					</table>
				</div>
				
			</div>
			
			<div class="section-info">
				<div class="numeric-info">
					<div>
						<h2>Numero Corsisti Attivi</h2>
						<h3 id="nbr1"><%= rpu.getCorsistiNum() %></h3>
					</div>
					<div>
						<h2>Numero Commenti</h2>
						<h3 id="nbr2"><%= rpu.getCommentiNum() %></h3>
					</div>
				</div>
				
				<%
					corsi = rpu.getLastCourse();
				%>
				
				<div class="last-course">
					<div>
						<h2>Ultimo corso</h2>
						<%
							for(String[] a: corsi) {
								String[] dataInizio = a[3].split("-");
								String[] dataFine = a[4].split("-");
						%>
						<div>
							<p><%= a[2] %></p>
							<p class="date">
								Durata: 
								<span><%= dataInizio[2] %>/<%= dataInizio[1] %>/<%= dataInizio[0] %></span>
								&nbsp;-&nbsp;
								<span><%= dataFine[2] %>/<%= dataFine[1] %>/<%= dataFine[0] %></span>
							</p>
							<p>Prezzo: <%= a[5] %>&euro;</p>
							<p>Descrizione: <%= a[6] %></p>
							<p>Aula predisposta: <%= a[7] %></p>
						</div>
						<%
							}
						%>
					</div>
				</div>
				
				<div class="numeric-info">
					<div>
						<h2>Durata media dei corsi</h2>
						<h3 id="nbr3"><%= rpu.getAvgDurata() %></h3>&nbsp;<strong>GIORNI</strong>
					</div>
				</div>
				
			</div>
			
			
			
			<div class="popular-courses-container">
		
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nominativo</th>
								<th>Precedenti formativi</th>
								<th> </th>
							</tr>
						</thead>
						<tbody>
						
							<%
								AdminFacade AF = AdminFacade.getIstance();
								Corsista[] corsisti = AF.getCorsisti();
								for(Corsista cor: corsisti) {
								
							%>
							
							<tr>
								<td><a class="nominativo" data-toggle="modal" data-target="#editModal_<%= cor.getCodCorsista() %>"><%= cor.getNomeCorsista() %> <%= cor.getCognomeCorsista()%></a></td>
								<td><%= (cor.getPrecedentiFormativi() == 1) ? "Si" : "No"   %></td>
								<td>
									<jsp:include page="modal.jsp">
										<jsp:param value="<%= cor.getCodCorsista() %>" name="id"/>
									</jsp:include>
								</td>
							</tr>
							
							
							<% 
								} 
							%>
							
						</tbody>
					</table>
				</div>
				
				
				<div class="table-responsive">
					<table class="table table-hover teacher-table">
						<thead>
							<tr>
								<th>Nome Corso</th>
								<th>Data Inizio</th>
								<th>Prezzo</th>
							</tr>
						</thead>
						<tbody>
						
							<%
								corsi = rpu.getCorsiDisponibili();
								for(String[] dati: corsi) {
									String[] data = dati[2].split("-");
							%>
							
							<tr>
								<td><%= dati[1] %></td>
								<td><%= data[2] %>/<%= data[1] %>/<%= data[0] %></td>
								<td><%= dati[3] %>&euro;</td>
							</tr>
							
							<% 
								} 
							%>
							
						</tbody>
					</table>
				</div>
				
			</div>
			
			
			<script>
				var xValues = [];
				var yValues = [];
				
				<%
					corsi = rpu.getCorsiPopolari();
					for(int i = 0; i < 3; i++) {
						String[] dati = corsi.get(i);
					
				%>
					xValues.push("<%= dati[1] %>");
					yValues.push(<%= dati[2] %>);
				<%
					}
				%>
				
				var barColors = ["#e16162", "#e16162","#e16162"];
				
				
				new Chart("myChart", {
				  type: "bar",
				  data: {
				    labels: xValues,
				    datasets: [{
				      backgroundColor: barColors,
				      data: yValues
				    }]
				  },
				  options: {
				    legend: {
				    	display: false,
			    	}
				  }
				});
			</script>
			
		</div>
	</main>
	<footer class="footer">
		<%@ include file="footer.html"%>
	</footer>
	<script src="js/animation.js"></script>
</body>
</html>
<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>