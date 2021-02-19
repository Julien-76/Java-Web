package be.technifutur.servlets.mapper;

import java.sql.*;

import be.technifutur.servlets.dto.Car;
import be.technifutur.servlets.dto.Carburant;
import be.technifutur.servlets.dto.Moteur;

public class Mapper {
	
    public static Car toDtoCar(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);                       //columnIndex = Position de la colonne, peut se faire également avec le nom de la colonne : int id = resultSet.getInt("car_id");
        String model = resultSet.getString(2).trim();       //columnIndex = Position de la colonne, peut se faire également avec le nom de la colonne : String model = resultSet.getString("car_model").trim();
        Double price = resultSet.getDouble(3);              //columnIndex = Position de la colonne, peut se faire également avec le nom de la colonne : Double price = resultSet.getDouble("car_price");
        Moteur moteur = new Moteur(resultSet.getInt(4),
                                   resultSet.getInt(5),
                                   Carburant.valueOf(resultSet.getString(6)),
                                   resultSet.getInt(7));
        return new Car(id, model, price, moteur);
    }

    public static Moteur toDtoMoteur(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int cylindree = resultSet.getInt(2);
        Carburant carburant = Carburant.valueOf(resultSet.getString(3));
        int puissance = resultSet.getInt(4);
        return new Moteur(id, cylindree, carburant, puissance);
    }

}
