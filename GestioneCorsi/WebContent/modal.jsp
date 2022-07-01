
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="it.betacom.businesscomponent.facade.AdminFacade"%>
<%@page import="it.betacom.businesscomponent.utilities.ReportUtility"%>
<%
if (request.getParameter("id") == null) {
	response.sendRedirect("report.jsp");
} else {
	long id = Long.parseLong(request.getParameter("id"));
	ReportUtility rpu2 = new ReportUtility();
	AdminFacade adm = AdminFacade.getIstance();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="editModal_<%=id%>" role="dialog" >
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<%
					Corsista cor = adm.getByIdCorsista(id);
				%>
				<h3>
					<%=cor.getNomeCorsista()%>
					<%=cor.getCognomeCorsista()%>
				</h3>
			</div>
			<div class="modal-body">
				<h3>Corsi sottoscritti</h3>
				<div class="table-responsive" style="text-align: right;">
					<table class="table table-hover">
						<thead>
							<tr>
								<th style="text-align: right;">Nome Corso</th>
								<th style="text-align: right;">Data Inizio</th>
								<th style="text-align: right;">Prezzo</th>
							</tr>
						</thead>
						<tbody>

							<%
								SimpleDateFormat formato3 = new SimpleDateFormat("dd-MM-yy");
								SimpleDateFormat formato4 = new SimpleDateFormat("dd/MM/yy");
								Vector<String[]> corsi2 = rpu2.getCorsiCorsista(id);;
								for (String[] dati : corsi2) {
									Calendar calendar = Calendar.getInstance();
									Date datainizio1 = formato3.parse(dati[3]);
									Date datafine1 = formato3.parse(dati[4]);
									calendar.setTime(datainizio1);
									String data_inizio1 = formato4.format(calendar.getTime());
									calendar.setTime(datafine1);
									String data_fine1 = formato4.format(calendar.getTime());
							%>

							<tr>
								<td><%=dati[1]%></td>
								<td><%=data_inizio1 %></td>
								<td><%=data_fine1 %></td>
							</tr>

							<%
								}
							%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<%
}
%>