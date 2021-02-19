package be.technifutur.servlets.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Util {
	
	public static void formatResponse(HttpServletResponse resp, Object objet) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();						// Permet de gérer la réponse sous forme de flux et d'écrire dans la réponse
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.addHeader("Access-Control-Allow-Origin", "*");		// Permet d'outrepasser le problème de CORS
		out.print(new Gson().toJson(objet));					// Affiche le flux
		out.flush();											// Vide le flux
		
	}

}
