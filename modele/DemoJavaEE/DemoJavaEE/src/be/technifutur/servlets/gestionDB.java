package be.technifutur.servlets;

import java.io.IOException;
import java.util.List;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.technifutur.servlets.dto.Car;
import be.technifutur.servlets.dto.Moteur;
import be.technifutur.servlets.services.CarService;
import be.technifutur.servlets.services.MoteurService;
import be.technifutur.servlets.utils.ConnexionPSQL;
import be.technifutur.servlets.utils.TestJDBC;

@WebServlet(name = "gestionDB", urlPatterns = {"/db", "/db/detail/*", "/db/delete/*", "/db/create", "/db/update/*"}, loadOnStartup = 7)
public class gestionDB extends HttpServlet {
	
	private final String HOST = "/DemoJavaEE";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**
		 * Pour tester la conection à la DB et récupérer en String les voitures
		 *
		 *
		 * TestJDBC tests = new TestJDBC(); List<String> messages =
		 * tests.executerTests(req);
		 * 
		 * req.setAttribute("messages", messages);
		 */
		
		/**
		 * Récupération de mon URL
		 */
		
		String pathInfo = req.getRequestURI();
		
		CarService serviceC = new CarService();
		MoteurService serviceM = new MoteurService();
		
		String choice = !pathInfo.equals(HOST + "/db") ? pathInfo.split("/")[3] : "db";		//Vérifie l'adresse fournie pour rediriger correctement avec le choice
		
		int id;
		
		switch (choice) {
			case "db" :
				req.setAttribute("messages", null);
				try {
					req.setAttribute("voitures", serviceC.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					req.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/gestionDB.jsp").forward(req, resp);
				}
				break;
			case "detail" :
				req.setAttribute("messages", null);
				
				id = Integer.parseInt(pathInfo.split("/")[4]);
				
				try {
					req.setAttribute("voiture", serviceC.selectByID(ConnexionPSQL.getInstance(), id));
				} catch (SQLException e) {
					req.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/gestionDBDetail.jsp").forward(req, resp);
				}
				break;
			case "delete" :
				req.setAttribute("messages", null);
				
				id = Integer.parseInt(pathInfo.split("/")[4]);
				
				try {
					serviceC.delete(ConnexionPSQL.getInstance(), id);
				} catch (SQLException e) {
					req.setAttribute("messages", e.getMessage());
				} finally {
					resp.sendRedirect(HOST + "/db");
				}
				break;
			case "create" :
				req.setAttribute("messages", null);
				
				try {
					req.setAttribute("moteurs", serviceM.selectAll(ConnexionPSQL.getInstance()));
				} catch (SQLException e) {
					req.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/gestionDBInsert.jsp").forward(req, resp);
				}
				break;
			case "update" :
				req.setAttribute("messages", null);
				
				id = Integer.parseInt(pathInfo.split("/")[4]);
				
				try {
					req.setAttribute("moteurs", serviceM.selectAll(ConnexionPSQL.getInstance()));
					req.setAttribute("voiture", serviceC.selectByID(ConnexionPSQL.getInstance(), id));
				} catch (SQLException e) {
					req.setAttribute("messages", e.getMessage());
				} finally {
					this.getServletContext().getRequestDispatcher("/WEB-INF/gestionDBUpdate.jsp").forward(req, resp);
				}
				break;
			default :
				break;
		}
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String modele = req.getParameter("modele");
		Double price = Double.parseDouble(req.getParameter("price"));
		int moteurID = Integer.parseInt(req.getParameter("moteur"));
		
		CarService serviceC = new CarService();
		MoteurService serviceM = new MoteurService();
		
		String pathInfo = req.getRequestURI();		
		String choice = !pathInfo.equals(HOST + "/db") ? pathInfo.split("/")[3] : "db";
		
		int id;
		
		switch (choice) {
		case "create" :
			try {
				Moteur moteur = serviceM.selectByID(ConnexionPSQL.getInstance(), moteurID);
				Car car = new Car(modele, price, moteur);
				serviceC.insert(ConnexionPSQL.getInstance(), car);	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				resp.sendRedirect(HOST + "/db");
			}
			break;
		case "update" :
			
			id = Integer.parseInt(pathInfo.split("/")[4]);
			
			try {
				Moteur moteur = serviceM.selectByID(ConnexionPSQL.getInstance(), moteurID);
				Car car = new Car(modele, price, moteur);
				serviceC.update(ConnexionPSQL.getInstance(), car, id);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				resp.sendRedirect(HOST + "/db");
			}
			break;
		}
		
	}

	
}
