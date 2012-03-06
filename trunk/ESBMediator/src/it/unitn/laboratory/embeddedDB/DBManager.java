package it.unitn.laboratory.embeddedDB;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DBManager 
{
	
	private Connection con;
	private static DBManager istance;
	
	private DBManager() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:staging.db");
	}
	
	public static DBManager  getIstance() throws ClassNotFoundException, SQLException
	{
		if(istance==null) istance=new DBManager();
		return istance;
	}
	
	public void createSchema() throws SQLException
	{
		File f = new File("Data/CreateStagingAreaCode.sql");
		
		BufferedReader br;		
		try 
		{
			String s ="";
			br = new BufferedReader(new FileReader(f));
			String l;
			while( (l = br.readLine()) != null )
			{
				s = s.concat(l+"\n");
			}
			br.close();	
			Statement stat = con.createStatement();
			stat.executeUpdate(s);
			stat.close();
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		
		return con;
	}
	
	public void closeConnection() throws SQLException
	{
		con.close();
		istance = null;
	}
	
	
	
	public static void main(String[] args) 
	{
		try 
		{
			DBManager.getIstance().createSchema();
		} catch (Exception e) 
		{
		}
	
	}
}
