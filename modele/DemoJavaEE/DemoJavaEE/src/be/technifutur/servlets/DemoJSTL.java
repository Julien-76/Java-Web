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


@WebServlet(name = "DemoJSTL", urlPatterns = {"/DemoJSTL"}, loadOnStartup = 5)
public class DemoJSTL extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Voiture> voitures = new ArrayList<>();
		
		Voiture v1 = new Voiture();
		v1.setModele("Porsche 911");
		v1.setCylindree(3000);
		voitures.add(v1);
		
		Voiture v2 = new Voiture();
		v2.setModele("Bugatti Chiron");
		v2.setCylindree(4500);
		voitures.add(v2);
		
		req.setAttribute("voitures", voitures);
		req.setAttribute("v2", v2);
		
		req.setAttribute("choose", "A");
		
		req.setAttribute("chaine", "Salut, Je suis fatigué; Et je veux des vacances.");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/demoJSTL.jsp").forward(req, resp);
	}

}
