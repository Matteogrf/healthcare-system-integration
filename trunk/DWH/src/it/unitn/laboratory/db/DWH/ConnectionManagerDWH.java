package it.unitn.laboratory.db.DWH;

import it.unitn.laboratory.db.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerDWH implements ConnectionManager
{
	private static final String DBName = "dwh"; // Name of the database
	private static final String userName = "root";
	private static final String pwd = "root";
	private static final String address = "192.168.1.41:3306";//"192.168.1.41:3306";	
	private static Connection db;

	private static ConnectionManagerDWH istance;

	public static ConnectionManagerDWH getInstance() throws ClassNotFoundException, SQLException 
	{
		if (istance == null)
			istance = new ConnectionManagerDWH();
		return istance;
	}

	private ConnectionManagerDWH() throws ClassNotFoundException, SQLException 
	{
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.pwd);
		System.out.println("Dovrei incazzarmi e sputare exxezzioni a cioooodoooo");
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
