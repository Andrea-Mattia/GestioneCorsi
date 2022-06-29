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
			
			<div>
			
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
				
				var barColors = ["red", "red","red"];
				
				
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
				    	display: false
			    	}
				  }
				});
			</script>
			
		</div>
	</main>
	<footer class="footer">
		<%@ include file="../footer.html"%>
	</footer>
	<script src="js/animation.js"></script>
</body>
</html>