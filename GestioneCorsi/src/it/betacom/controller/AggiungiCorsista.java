package it.betacom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.businesscomponent.model.Corsista;

@WebServlet("/aggiungiCorsista")
public class AggiungiCorsista extends HttpServlet {
	private static final long serialVersionUID = -8041736586832262762L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista c = new Corsista();
		
		try {
			c.setNomeCorsista(request.getParameter("nome"));
			c.setCognomeCorsista(request.getParameter("cognome"));
			c.setPrecedentiFormativi(Integer.parseInt(request.getParameter("precedentiFormativi")));
			AdminFacade aF = AdminFacade.getIstance();
			aF.createCorsista(corsista);
			response.sendRedirect("home.jsp");
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}