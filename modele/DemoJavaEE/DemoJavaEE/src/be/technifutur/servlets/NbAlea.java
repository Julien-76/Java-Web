package be.technifutur.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.servlets.beans.Voiture;

public class NbAlea extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Random r = new Random();
		int alea = r.nextInt((100 - 1) + 1);
		
		req.setAttribute("nombre", alea);
		
		// Cette ligne doit être la dernière
		this.getServletContext().getRequestDispatcher("/WEB-INF/affichenombrealea.jsp").forward(req, resp);
		
	}

}
