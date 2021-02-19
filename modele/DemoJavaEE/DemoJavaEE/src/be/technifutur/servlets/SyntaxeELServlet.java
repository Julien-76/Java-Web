package be.technifutur.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.servlets.beans.Voiture;

public class SyntaxeELServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("message", "Voici mon message");
		
		req.setAttribute("voiture", create());
		
		List<String> personnes = new ArrayList<>();
		personnes.add("Aubry");
		personnes.add("Clotilde");
		personnes.add("Greg");
		req.setAttribute("personnes", personnes);
		req.setAttribute("listeLI", createViewList());
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/el.jsp").forward(req, resp);
	}
	
	private Voiture create() {
		Voiture v = new Voiture();
		v.setModele("Ford");
		v.setCylindree(1999);
		return v;
	}
	
	public String createViewList() {
        List<String> personnes = new ArrayList<>();
        personnes.add("Aubry");
        personnes.add("Clotilde");
        personnes.add("Greg");
        
        String output = "";
        for (String s : personnes) {
            output += "<li>"+ s +"</li>";
        }        
        return output;        
    }

}
