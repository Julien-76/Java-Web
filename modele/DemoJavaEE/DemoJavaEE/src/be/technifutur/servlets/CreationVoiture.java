package be.technifutur.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.servlets.beans.Voiture;

@WebServlet(name = "CreationVoiture", urlPatterns = {"/creerVoiture"}, loadOnStartup = 4)
public class CreationVoiture extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Voiture v = new Voiture();
		v.setModele(req.getParameter("modele"));
		v.setCylindree(Integer.parseInt(req.getParameter("cylindree")));
		
		req.setAttribute("voiture", v);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherVoiture.jsp").forward(req, resp);
	}

}
