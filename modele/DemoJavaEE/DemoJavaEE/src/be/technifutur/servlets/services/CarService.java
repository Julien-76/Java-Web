package be.technifutur.servlets.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import be.technifutur.servlets.dto.Car;
import be.technifutur.servlets.mapper.Mapper;

public class CarService implements Crudable<Car, Integer>{

	@Override
    public List<Car> selectAll(Connection c) throws SQLException {

        List<Car> output = new ArrayList<>();

        Statement statement = c.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.car");
        ResultSet resultSet = statement.executeQuery("SELECT \"car_id\", \"car_model\", \"car_price\", \"motor_id\", \"motor_cylindree\", \"motor_carburant\", \"motor_puissance\"\n" +
                "FROM car\n" +
                "INNER JOIN motor\n" +
                "ON \"car_motor\" = \"motor_id\"" +
                " ORDER BY \"car_id\";");
        while(resultSet.next()) {
            Car v = Mapper.toDtoCar(resultSet);                                 //Appel de la méthode adaptée du Mapper pour définir l'objet Voiture avec les bons paramètres
            output.add(v);
        }

        return output;
    }

    @Override
    public Car selectByID(Connection c, Integer id) throws SQLException {

        String requete = "SELECT \"car_id\", \"car_model\", \"car_price\", \"motor_id\", \"motor_cylindree\", \"motor_carburant\", \"motor_puissance\"\n" +
                "FROM car\n" +
                "INNER JOIN motor\n" +
                "ON \"car_motor\" = \"motor_id\"" +
                "WHERE \"car_id\" = ?";
        Car v = null;
        PreparedStatement preparedStatement = c.prepareStatement(requete);		// La PreparedStatement protège d'injections SQL
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            v = Mapper.toDtoCar(resultSet);
        }

        return v;
    }

    @Override
    public void insert(Connection c, Car v) throws SQLException {

        String requete = "INSERT INTO public.car VALUES (DEFAULT, ?, ?, ?)";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, v.getModel());
        preparedStatement.setDouble(2, v.getPrice());
        preparedStatement.setInt(3, v.getMoteur().getId());

        preparedStatement.executeUpdate();

    }

    @Override
    public void update(Connection c, Car v, Integer id) throws SQLException {

        String requete = "UPDATE public.car SET \"car_model\" = ?, \"car_price\" = ?, \"car_motor\" = ? WHERE \"car_id\" = ?";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setString(1, v.getModel());
        preparedStatement.setDouble(2, v.getPrice());
        preparedStatement.setInt(3, v.getMoteur().getId());
        preparedStatement.setInt(4, id);

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(Connection c, Integer id) throws SQLException {

        String requete = "DELETE FROM public.car WHERE \"car_id\" = ?";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

		
}
