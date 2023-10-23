package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.DBConnection;
import bean.CustomerBean;

public class CustomerDao 
{
	public static int insertCustomer(CustomerBean bean)
	{
		Connection conn = DBConnection.getConnection();
		int rowsAffected = 0;
		String insertQuery = "Insert into customer (Name,Email,Password,Contact,City,State) VALUES(?,?,?,?,?,?)";
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getContact());
			pstmt.setString(5, bean.getCity());
			pstmt.setString(6, bean.getState());
			rowsAffected = pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}

	public static int customerLoginCredentials(String Email,String Password)
	{
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select userId,email,password from customer";
		int userId =0;
		boolean credential = false;
		boolean admin = false;
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				userId = rs.getInt(1);
				String email = rs.getString(2);
				String password = rs.getString(3);
				if(Email.equals("jaypatel@gmail.com") && Password.equals("jaypatel"))
				{
					admin = true;
				}
				if(email.equals(Email) && password.equals(Password))
				{
					credential = true;
					break;
				}
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(admin)
		{
			return -1;
		}
		else if(credential)
		{			
			return userId;
		}
		else
		{
			return -2;
		}
	}
}
