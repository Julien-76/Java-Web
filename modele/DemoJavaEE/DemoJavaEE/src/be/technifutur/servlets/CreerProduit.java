package be.technifutur.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.servlets.beans.Produit;
import be.technifutur.servlets.beans.Produit.TypeProd;

@WebServlet(name = "CreerProduit", urlPatterns = {"/CreerProduit"}, loadOnStartup = 6)
public class CreerProduit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Produit> produits = new ArrayList<>();
		
		Produit p1 = new Produit("Pomme", 5, 3, TypeProd.ALIMENT);
		produits.add(p1);
		
		Produit p2 = new Produit("Etagère", 25, 2, TypeProd.MEUBLE);
		produits.add(p2);
		
		Produit p3 = new Produit("Pelle", 9, 0, TypeProd.OUTIL);
		produits.add(p3);
		
		Produit p4 = new Produit("Marteau", 7, 2, TypeProd.OUTIL);
		produits.add(p4);
		
		req.setAttribute("produits", produits);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficheProduit.jsp").forward(req, resp);
		
	}

}
