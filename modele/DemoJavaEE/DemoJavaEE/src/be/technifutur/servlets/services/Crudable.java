package be.technifutur.servlets.services;

import java.sql.*;
import java.util.List;

public interface Crudable<DTO, TID> {
	
	List<DTO> selectAll(Connection c) throws SQLException;

    DTO selectByID(Connection c, TID id) throws SQLException;

    void insert(Connection c, DTO v) throws SQLException;

    void update(Connection c, DTO v, TID id) throws SQLException;

    void delete(Connection c, TID id) throws SQLException;

}
