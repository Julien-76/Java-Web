package be.technifutur.servlets.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import be.technifutur.servlets.dto.Moteur;
import be.technifutur.servlets.mapper.Mapper;

public class MoteurService implements Crudable<Moteur, Integer> {

	@Override
	public List<Moteur> selectAll(Connection c) throws SQLException {
		List<Moteur> output = new ArrayList<>();

        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.motor ORDER BY \"motor_id\"");
        while(resultSet.next()) {
            Moteur m = Mapper.toDtoMoteur(resultSet);
            output.add(m);
        }

        return output;
	}

	@Override
	public Moteur selectByID(Connection c, Integer id) throws SQLException {
		String requete = "SELECT * FROM public.motor WHERE \"motor_id\" = ?";
        Moteur m = null;
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            m = Mapper.toDtoMoteur(resultSet);
        }

        return m;
	}

	@Override
	public void insert(Connection c, Moteur m) throws SQLException {
		String requete = "INSERT INTO public.motor VALUES (DEFAULT, ?, ?::carb, ?)";
        // ?::carb permet de caster la String du carburant dans le bon type pour l'ENUM de la DB en SQL
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setInt(1, m.getCylindree());
        preparedStatement.setString(2, m.getCarburant().toString());
        preparedStatement.setInt(3,m.getPuissance());

        preparedStatement.executeUpdate();
	}

	@Override
	public void update(Connection c, Moteur m, Integer id) throws SQLException {
		String requete = "UPDATE public.motor SET \"motor_cylindree\" = ?, \"motor_carburant\" = ?::carb, \"motor_puissance\" = ? WHERE \"motor_id\" = ?";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setInt(1, m.getCylindree());
        preparedStatement.setString(2, m.getCarburant().toString());
        preparedStatement.setInt(3,m.getPuissance());
        preparedStatement.setInt(4, id);

        preparedStatement.executeUpdate();
	}

	@Override
	public void delete(Connection c, Integer id) throws SQLException {
		String requete = "DELETE FROM public.motor WHERE \"motor_id\" = ?";
        PreparedStatement preparedStatement = c.prepareStatement(requete);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
	}

}
