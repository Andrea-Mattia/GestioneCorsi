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
		String codAdmin = request.getParameter("codAdmin");
		String password = AlgoritmoMD5.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String adminpass = null;
		if(codAdmin != null && password != null) {
			try {
				LoginUtility lU = new LoginUtility();
				adminpass = lU.getAdminPass(codAdmin);
				if(adminpass != null) {
					session.getAttribute(password);
					response.sendRedirect("home.jsp");
				}else {
					String valid = (String) session.getAttribute("try");
					int x = Integer.parseInt(valid);
					if(x < 5) {
						session.setAttribute("try", x++);
					}
					response.sendRedirect("login.jsp");
				}
			}catch(Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}else {
			response.sendRedirect("accessonegato.jsp");
		}
	}

}
