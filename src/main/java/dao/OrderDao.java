package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Util.DBConnection;
import bean.OrderBean;

public class OrderDao 
{
	public static String totalAmount(int medicineId,int userId)
	{
		Connection conn = DBConnection.getConnection();
		String query = "Select TotalCartAmount from cart where medicineId = "+medicineId+" and userId = "+userId+"";
		ResultSet rs = null;
		String totalAmount = null;
		try 
		{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				totalAmount = rs.getString(1);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return totalAmount;
	}
	
	public static int insertOrderData(OrderBean bean)
	{
		Connection conn = DBConnection.getConnection();
		int rowsAffected = 0;	
		int availableMedicine = 0;
		int removeFromCart = 0;
		availableMedicine = updateMedicineQuantity(bean.getMedicineId(),bean.getQuantity(),bean.getUserId());
		if(availableMedicine>0)
		{
			String insertQuery = "Insert into Odr(userId,medicineId,medicineName,quantity,amount,TotalAmount,DATE) VALUES(?,?,?,?,?,?,?)";
			try 
			{
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);
				pstmt.setInt(1,bean.getUserId());
				pstmt.setInt(2, bean.getMedicineId());
				pstmt.setString(3, bean.getMedicineName());
				pstmt.setString(4, bean.getQuantity());
				pstmt.setString(5, bean.getAmount());
				pstmt.setString(6, totalAmount(bean.getMedicineId(),bean.getUserId()));
				pstmt.setString(7, bean.getDate());
				
				rowsAffected = pstmt.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			removeFromCart = CartDao.removeMedicineFromCart(bean.getUserId(), bean.getMedicineId());
			return rowsAffected;
		}
		else
		{
			return rowsAffected;
		}
	}
	
	public static int updateMedicineQuantity(int medicineId,String quantity,int userId)
	{
		Connection conn = DBConnection.getConnection();
		String updateQuery = "Update Medicine Set Available_Qty = Available_Qty - "+quantity+"  where MedicineId = "+medicineId+" and Available_Qty >= "+quantity+";";
		Statement stmt = null;
		int rowsAffected = 0;
		try
		{
			stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(updateQuery);
			System.out.println("Medicine Quantity Updated");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	public static String showSymptoms(int userId, int medicineId)
	{
		Connection conn = DBConnection.getConnection();
//		LocalDate currentDate = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		String date = currentDate.format(formatter);
		String selectQuery = "select Symptoms from medicine where MedicineId = "+medicineId+"";
		//String selectQuery = "Select DISTINCT odr.medicineId,medicine.medicineId,odr.medicineName,odr.Quantity,odr.amount,odr.TotalAmount,medicine.Symptoms from odr,medicine where odr.medicineId = medicine.medicineId and userId = "+userId+" and medicine.medicineId= "+medicineId+" and  "+date+"  = odr.date";
		ResultSet rs = null;
		String symptoms = null;
		try 
		{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
//				String medicineName = rs.getString(1);
//				String quantity = rs.getString(2);
//				String amount = rs.getString(3);
//				String totalAmount = rs.getString(4);
				symptoms = rs.getString(1);
//				bean = new OrderBean(symptoms);
//				list.add(bean);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return symptoms;
	}

	public static ArrayList<OrderBean> previousOrders(int userId)
	{
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select * from odr where userId = "+userId+" ";
		ArrayList<OrderBean> list = new ArrayList<OrderBean>();
		OrderBean bean = null;
		try 
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				int medicineId = rs.getInt(3);
				String medicineName = rs.getString(4);
				String quantity = rs.getString(5);
				String amount = rs.getString(6);
				String totalAmount = rs.getString(7);
				String date = rs.getString(8);
				bean = new OrderBean(medicineId,medicineName,quantity,amount,totalAmount,date);
				list.add(bean);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<OrderBean> orderAllInCart(int userId) 
	{
		ArrayList<OrderBean> list = new ArrayList<OrderBean>();
		OrderBean bean = null;
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select * from cart where userId = "+userId+"";
		int rowsAffected = 0;
		int removeFromCart = 0;
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		try 
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				Connection conn1 = DBConnection.getConnection();
				Statement stmt1 = conn1.createStatement();
				int userrId = rs.getInt(2);
				int medicineId = rs.getInt(3);
				String medicineName = rs.getString(4);
				String quantity = rs.getString(5);
				String amount = rs.getString(6);
				String totalAmount = rs.getString(7);
				String date = currentDate.format(formatter); 
				String insertQuery = "Insert into Odr(userId,medicineId,medicineName,quantity,amount,TotalAmount,DATE) VALUES(" + userrId + ", " + medicineId + ", '" + medicineName + "', '" + quantity + "', '" + amount + "', '" + totalAmount + "', '" + date + "')";				
				rowsAffected = stmt1.executeUpdate(insertQuery);
				bean = new OrderBean(userrId,medicineId,medicineName,quantity,amount,totalAmount,date);
				list.add(bean);
			}
			removeFromCart = CartDao.removeAllMedicineFromCart(userId);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<OrderBean> showSymptomsforAllMedicine(int userId)
	{
		Connection conn = DBConnection.getConnection();
		ArrayList<OrderBean> list = new ArrayList<OrderBean>();
		OrderBean bean = null;
		String symptoms = null;
		String selectQuery = "select symptoms from medicine where medicineId in(select medicineId from cart where userId = "+userId+")";
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				symptoms = rs.getString(1);
				bean = new OrderBean(symptoms);
				list.add(bean);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public static int buyNow(OrderBean bean)
	{
		Connection conn = DBConnection.getConnection();
		int rowsAffected = 0;	
		int availableMedicine = 0;
		availableMedicine = updateMedicineQuantity(bean.getMedicineId(),bean.getQuantity(),bean.getUserId());
		if(availableMedicine>0)
		{
			String insertQuery = "Insert into Odr(userId,medicineId,medicineName,quantity,amount,TotalAmount,DATE) VALUES(?,?,?,?,?,?,?)";
			try 
			{
				PreparedStatement pstmt = conn.prepareStatement(insertQuery);
				pstmt.setInt(1,bean.getUserId());
				pstmt.setInt(2, bean.getMedicineId());
				pstmt.setString(3, bean.getMedicineName());
				pstmt.setString(4, bean.getQuantity());
				pstmt.setString(5, bean.getAmount());
				pstmt.setString(6, bean.getAmount());
				pstmt.setString(7, bean.getDate());
				rowsAffected = pstmt.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return rowsAffected;
		}
		else
		{
			return rowsAffected;
		}
	}	
}