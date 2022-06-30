<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.betacom.businesscomponent.utilities.ReportUtility"%>
<%@page import="java.util.Vector"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>mikasa es tu casa</title>
<%@ include file="cdn.html"%>
<link rel="stylesheet" href="css/style.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>

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
						<h2>Numero Corsisti</h2>
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
							SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
							for(String[] a: corsi) {
				                Date dateinizio = formato.parse(a[3]);
				                Date datefine = formato.parse(a[4]);
				                Calendar inizio_cal = Calendar.getInstance();
				                Calendar fine_cal = Calendar.getInstance();
				                inizio_cal.setTime(dateinizio);
				                fine_cal.setTime(datefine);
						%>
						<div>
							<p><%= a[2] %></p>
							<p class="date">
								Durata: 
								<span><%= inizio_cal.get(Calendar.DAY_OF_MONTH) %>/</span><span><%= inizio_cal.get(Calendar.MONTH) %>/</span><span><%= inizio_cal.get(Calendar.YEAR) %></span>
								<span> &nbsp; - &nbsp; </span>
								<span><%= fine_cal.get(Calendar.DAY_OF_MONTH) %>/</span><span><%= fine_cal.get(Calendar.MONTH) %>/</span><span><%= fine_cal.get(Calendar.YEAR) %></span>
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
						<h3 id="nbr3"><%= rpu.getAvgDurata() %></h3>
					</div>
				</div>
				
			</div>
			
			
			
			<div class="popular-courses-container">
		
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Cognome</th>
								<th>Precedenti formativi</th>
							</tr>
						</thead>
						<tbody>
						
							<%
								AdminFacade AF = AdminFacade.getIstance();
								Corsista[] corsisti = AF.getCorsisti();
								for(Corsista cor: corsisti) {
								
							%>
							
							<tr>
								<td><%= cor.getNomeCorsista() %></td>
								<td><%= cor.getCognomeCorsista()%></td>
								<td><%= (cor.getPrecedentiFormativi() == 1) ? true : false   %></td>
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
									SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yy");
					                Calendar calendar = Calendar.getInstance();
					                Date new_course = formato.parse(dati[2]);
					                calendar.setTime(new_course);
					                String data_inizio = formato2.format(calendar.getTime());
							%>
							
							<tr>
								<td><%= dati[1] %></td>
								<td><%= data_inizio %></td>
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