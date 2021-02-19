package be.technifutur.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.servlets.beans.Voiture;

public class Test extends HttpServlet {
	
	// Ce fichier est une servlet, définie dans le fichier web.xml

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String paramAuteur = req.getParameter("auteur");
		
		String message = "Transmission de données du fichier Java vers le fichier JSP : réussi ! " + paramAuteur;
		req.setAttribute("transmission", message);
		
		// Création d'une voiture via le bean Voiture.java
		
		Voiture voiture = new Voiture();
		voiture.setModele("Porsche 911");
		voiture.setCylindree(3500);
		req.setAttribute("voiture", voiture);
		
		
		List<String> personnes = new ArrayList<>();
		personnes.add("Aubry");
		personnes.add("Clotilde");
		personnes.add("Greg");
		req.setAttribute("personnes", personnes);
		
		
		Map<String, Integer> cotations = new HashMap<>();
		cotations.put("Math", 0);
		cotations.put("Programmation", 10);
		req.setAttribute("cotations", cotations);
		
		
		// Cette ligne doit être la dernière
		this.getServletContext().getRequestDispatcher("/WEB-INF/testvue.jsp").forward(req, resp);
		
		/* super.doGet(req, resp);
		 * resp.setContentType("text/html"); resp.setCharacterEncoding("UTF-8");
		 * PrintWriter out = resp.getWriter(); out.println("<!DOCTYPE html>");
		 * out.println("<html>"); out.println("<head>");
		 * out.println("<meta charset = \"UTF-8>\" />"); out.println("</head>");
		 * out.println("<body>");
		 * out.println("<p> Texte généré depuis une servlet</p>");
		 * out.println("</body>"); out.println("</html>");
		 */
	}

}
