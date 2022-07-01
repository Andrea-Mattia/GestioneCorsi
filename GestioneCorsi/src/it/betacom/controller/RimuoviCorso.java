package it.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.facade.AdminFacade;

@WebServlet("/rimuoviCorso")
public class RimuoviCorso extends HttpServlet {
	private static final long serialVersionUID = 2768506196054056549L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			if(id != null) {
				AdminFacade.getIstance().deleteCorso(Long.valueOf(id));
			}
			response.sendRedirect("eliminacorsi.jsp");
		} catch (DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
