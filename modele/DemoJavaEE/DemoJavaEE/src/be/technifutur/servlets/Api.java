	package be.technifutur.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import be.technifutur.servlets.dto.Car;
import be.technifutur.servlets.dto.Carburant;
import be.technifutur.servlets.dto.Moteur;
import be.technifutur.servlets.services.CarService;
import be.technifutur.servlets.services.MoteurService;
import be.technifutur.servlets.utils.ConnexionPSQL;
import be.technifutur.servlets.utils.Message;
import be.technifutur.servlets.utils.Util;

@WebServlet(name = "api", urlPatterns = {"/api", "/api/*"}, loadOnStartup = 8)
public class Api extends HttpServlet {
	
	//Transformation de données de BDD en données objet Java, puis en JSON
	
	private final String HOST = "/DemoJavaEE";
	
	private final CarService carService = new CarService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * Démo de base pour retourner un JSON
		 */
		/*
		Car testJSON = new Car(99, "Mercedes Classe A", 25500.95, new Moteur(65, Carburant.Essence, 1995));
		String carToString = new Gson().toJson(testJSON);	//Transformation de l'objet en String pour JSON
		
		PrintWriter out = resp.getWriter();					//Permet de gérer la réponse sous forme de flux et d'écrire dans la réponse
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(carToString);								//Affiche le flux
		out.flush();                                        //Vide le flux
		*/
		
		
		
		String pathInfo = req.getRequestURI();
		
		String choice = !pathInfo.equals(HOST + "/api") ? pathInfo.split("/")[3] : "api";
		
		int id;
		
		switch (choice) {
			case "api" :
				try {
					Util.formatResponse(resp, carService.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default :
				id = Integer.parseInt(pathInfo.split("/")[3]);
				try {
					Util.formatResponse(resp, carService.selectByID(ConnexionPSQL.getInstance(), id));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pathInfo = req.getRequestURI();
		
		int id = Integer.parseInt(pathInfo.split("/")[3]);
		
		try {
			carService.delete(ConnexionPSQL.getInstance(), id);
			Util.formatResponse(resp, new Message("La voiture d'ID " + id + " a bien été supprimée"));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Car carToAdd = new Gson().fromJson(req.getReader(), Car.class);
		
		try {
			carService.insert(ConnexionPSQL.getInstance(), carToAdd);
			Util.formatResponse(resp, new Message("La voiture " + carToAdd.getModel() + " a bien été créée"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Car carToModify = new Gson().fromJson(req.getReader(), Car.class);
		
		String pathInfo = req.getRequestURI();
		
		int id = Integer.parseInt(pathInfo.split("/")[3]);
		
		try {
			carService.update(ConnexionPSQL.getInstance(), carToModify, id);
			Util.formatResponse(resp, new Message("La voiture à l'id " + id + " a bien été modifiée"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
