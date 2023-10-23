package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Util.DBConnection;
import bean.AddressBean;

public class AddressDao 
{
	public static int insertAddress(AddressBean address,int userId)
	{
		Connection conn= DBConnection.getConnection();
		String query = "Insert into Address (userId,FullName,Address_Line_1,Address_Line_2,city,pincode,state)VALUES(?,?,?,?,?,?,?)";
		int rowsAffected = 0;
		try
		{
			
			PreparedStatement pstmt = conn.prepareStatement(query);			
			pstmt.setInt(1, userId);
			pstmt.setString(2, address.getName());
			pstmt.setString(3, address.getAddress_1());
			pstmt.setString(4, address.getAddress_2());
			pstmt.setString(5, address.getCity());
			pstmt.setString(6, address.getPincode());
			pstmt.setString(7, address.getState());
			rowsAffected = pstmt.executeUpdate();
			System.out.println("insertAddeess try block");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
