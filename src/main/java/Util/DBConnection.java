package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection 
{
	public static Connection getConnection()
	{
		Connection conn = null;
		Properties pro = new Properties();
		try 
		{
			FileInputStream fin = new FileInputStream("D:\\Jay Project\\Online Medical\\src\\main\\java\\Util\\dbProperties.txt");
			pro.load(fin);
			String URL = pro.getProperty("URLNAME");
			String Driver = pro.getProperty("DRIVERNAME");
			String Username = pro.getProperty("USERNAME");
			String Password = pro.getProperty("PASSWORD");
			
			//1- Load Driver class
			Class.forName(Driver);
			
			//2- Pass credential 
			conn = DriverManager.getConnection(URL, Username, Password);
		}
		catch (FileNotFoundException e) 
		{		
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
	return conn;
	}
	
	public static void main(String args[])
	{
		Connection conn = DBConnection.getConnection();
		System.out.println("Database Connected");
	}
}