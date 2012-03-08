package it.unitn.laboratory.dataproducer.DB;

import java.sql.*;
import java.util.Properties;

public class ConnectionManager {
	private static final String DBName = "eventsdb"; // Name of the database
	private static final String userName = "root";
	private static final String pwd = "root";
	private static final String address = "192.168.178.25:3306";//"192.168.1.41:3306";
	private static Connection db;

	private static ConnectionManager istance;

	public static ConnectionManager getInstance() throws ClassNotFoundException, SQLException 
	{
		if (istance == null)
			istance = new ConnectionManager();
		return istance;
	}

	private ConnectionManager() throws ClassNotFoundException, SQLException 
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
