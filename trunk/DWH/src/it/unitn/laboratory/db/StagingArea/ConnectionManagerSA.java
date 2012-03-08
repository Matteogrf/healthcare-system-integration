package it.unitn.laboratory.db.StagingArea;

import it.unitn.laboratory.db.ConnectionManager;

import java.sql.*;
import java.util.Properties;

public class ConnectionManagerSA implements ConnectionManager{
	private static final String DBName = "stagingarea"; // Name of the database
	private static final String userName = "root";
	private static final String pwd = "root";
	private static final String address = "192.168.178.25:3306";//"192.168.1.41:3306";
	private static Connection db;

	private static ConnectionManagerSA istance;

	public static ConnectionManager getInstance() throws ClassNotFoundException, SQLException 
	{
		if (istance == null)
			istance = new ConnectionManagerSA();
		return istance;
	}

	private ConnectionManagerSA() throws ClassNotFoundException, SQLException 
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
