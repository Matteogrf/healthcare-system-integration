package it.unitn.laboratory.db.DWH;

import it.unitn.laboratory.db.ConnectionManager;

import java.sql.*;
import java.util.Properties;

public class ConnectionManagerWDH implements ConnectionManager
{
	private static final String DBName = "dwh"; // Name of the database
	private static final String userName = "root";
	private static final String pwd = "root";
	private static final String address = "192.168.1.41:3306";//"192.168.178.25:3306";;	
	private static Connection db;

	private static ConnectionManagerWDH istance;

	public static ConnectionManagerWDH getInstance() throws ClassNotFoundException, SQLException 
	{
		if (istance == null)
			istance = new ConnectionManagerWDH();
		return istance;
	}

	private ConnectionManagerWDH() throws ClassNotFoundException, SQLException 
	{
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.pwd);
		Class.forName("com.mysql.jdbc.Driver");
		db = DriverManager.getConnection("jdbc:mysql://" + this.address + "/"+DBName,
				connectionProps);
	}
	
	public Connection getConnection()
	{
		return db;
	}
	
	public void disconnect() throws SQLException
	{
		if(db != null)
			db.close();
	}
}
