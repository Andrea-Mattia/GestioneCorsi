package it.betacom.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.businesscomponent.utilities.LoginUtility;
import it.betacom.security.AlgoritmoMD5;

@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = -2249710815094737620L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String codAdmin = request.getParameter("username");
		String password = AlgoritmoMD5.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String adminpass = null;
		if(codAdmin != null && password != null) {
			try {
				LoginUtility lU = new LoginUtility();
				adminpass = lU.getAdminPass(codAdmin);
				if(adminpass != null) {
					session.setAttribute("username", codAdmin);
					response.sendRedirect("home.jsp");
				}else {
					if(session.getAttribute("try") == null) {
						session.setAttribute("try", "0");
					}
						String valid = (String) session.getAttribute("try");
						int x = Integer.parseInt(valid);
						if(x < 4) {
							x++;
							System.out.println(x);
							session.setAttribute("try", String.valueOf(x));
							response.sendRedirect("login.jsp");
						} else {
							System.out.println("Sono arrivato qui");
							response.sendRedirect("accessonegato.jsp");
						}
				}
			}catch(Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
	}
}
