package be.technifutur.servlets.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class TestJDBC {
	
	private List<String> messages = new ArrayList<>();
	
	public List<String> executerTests(HttpServletRequest request) {
		
		try {
			Statement statement = ConnexionPSQL.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM public.car");
			while (resultSet.next()) {
				String data = "ID : " + resultSet.getInt(1) + " - Modèle : "
							  + resultSet.getString(2) + " - Prix : "
							  + resultSet.getDouble(3);
				messages.add(data);
			}
		} catch (SQLException e){
			messages.add(e.getMessage());
		}
		
		return messages;
		
	}

}
