<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="error.jsp"%>

<%
	int time = Integer.valueOf((String) session.getAttribute("ban"));
	if(request.getParameter("timeHidden") != null && !request.getParameter("timeHidden").equals("")) {
		time = Integer.valueOf(request.getParameter("timeHidden"));
		time--;
	}
		
	if(time > 0) {
%>
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
					<p>Tempo rimanente: <span id="time"><%= time %></span> minuti</p>
				</div>
				<form action="#" method="post" name="hiddenForm" id="hiddenForm">
					<input type="hidden" name="timeHidden" id="timeHidden" value="<%= time %>">
				</form>
			</div>
		
		</div> 
	</main>
	
	<script type="text/javascript">
	
	window.onload = (event) => {
		setTimeout(function() {
			document.hiddenForm.submit()
	    }, 60000);
	};
	
	</script>
	
	<footer class="footer">
		<%@ include file="footer.html" %>
	</footer>
	
</body>
</html>
<%
	} else {
		session.setAttribute("ban", "0");
		session.setAttribute("try", "0");
		response.sendRedirect("login.jsp");
	}
%>