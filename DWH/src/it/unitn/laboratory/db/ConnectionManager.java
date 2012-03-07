package it.unitn.laboratory.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager 
{
	public Connection getConnection();
	public void disconnect() throws SQLException;
}
