package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Util.DBConnection;
import bean.MedicineBean;

public class MedicineDao 
{
	MedicineBean medicine = new MedicineBean();
	public static int addMedicine(MedicineBean medicine)
	{
		Connection conn = DBConnection.getConnection();
		String insertQuery = "Insert into Medicine (MedicineName,Available_Qty,Price,Expiry_date,Symptoms,Medicine_Image)values(?,?,?,?,?,?)";
		int rowsAffected = 0;
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, medicine.getMedicine_Name());
			pstmt.setString(2, medicine.getAvailable_qty());
			pstmt.setString(3, medicine.getPrice());
			pstmt.setString(4, medicine.getExpiry_date());
			pstmt.setString(5, medicine.getsymptoms());
			pstmt.setString(6, medicine.getMedicine_image());
			rowsAffected = pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	//This method will be called in ShowAllMedicine.jsp without servlet
	public static ArrayList<MedicineBean> showAllMedicine()
	{
		ArrayList<MedicineBean> list = new ArrayList<MedicineBean>();
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select * from Medicine";
		MedicineBean bean = null;
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				int medicineId = rs.getInt(1);
				String medicine_name = rs.getString(2);
				String quantity = rs.getString(3);
				String price = rs.getString(4);
				String expiry_date = rs.getString(5);
				String symptoms = rs.getString(6);
				String medicine_image = rs.getString(7);
				bean = new MedicineBean(medicineId,medicine_name,quantity,price,expiry_date,symptoms,medicine_image);
				list.add(bean);
			}
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	//This method will be called in CheckStock.jsp without servlet
	public static ArrayList<MedicineBean> checkStock()
	{
		ArrayList<MedicineBean> list = new ArrayList<MedicineBean>();
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select * from Medicine where Available_Qty < 5";
		MedicineBean bean = null;
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				int medicineId = rs.getInt(1);
				String medicine_name = rs.getString(2);
				String quantity = rs.getString(3);
				String price = rs.getString(4);
				String expiry_date = rs.getString(5);
				String symptoms = rs.getString(6);
				String medicine_image = rs.getString(7);
				bean = new MedicineBean(medicineId,medicine_name,quantity,price,expiry_date,symptoms,medicine_image);
				list.add(bean);
			}
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	//This method will be called in CheckExpiredMedicine.jsp without servlet
	public static ArrayList<MedicineBean> checkExpiredMedicine()
	{
		ArrayList<MedicineBean> list = new ArrayList<MedicineBean>();
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select * from Medicine where sysdate() >= Expiry_date";
		MedicineBean bean = null;
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				int mid = rs.getInt(1);
				String medicine_name = rs.getString(2);
				String quantity = rs.getString(3);
				String price = rs.getString(4);
				String expiry_date = rs.getString(5);
				bean = new MedicineBean(mid,medicine_name,quantity,price,expiry_date);
				list.add(bean);
			}
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	public static int removeMedicine(int MedicineId)
	{
		ArrayList<MedicineBean> list = new ArrayList<MedicineBean>();
		Connection conn = DBConnection.getConnection();
		String deleteQuery = "Delete from Medicine where MedicineId = "+MedicineId+"";
		int rowsAffected = 0;
		try 
		{
			Statement stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(deleteQuery);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}

	//Method for Customer
	public static ArrayList<MedicineBean> searchMedicine(String medicineOrsymptoms)
	{
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select MedicineId,MedicineName , Symptoms , price , Expiry_date from Medicine";
		ArrayList<MedicineBean> list = new ArrayList<MedicineBean>();
		MedicineBean bean = null;
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(selectQuery);
			medicineOrsymptoms = medicineOrsymptoms.toLowerCase();
			while(rs.next())
			{
				int medicineId = rs.getInt(1);
				String medicine_name = (rs.getString(2)).toLowerCase();
				String symptoms = (rs.getString(3).toLowerCase());
				String price = rs.getString(4);
				String expire_date = rs.getString(5);
				if(medicine_name.equals(medicineOrsymptoms) || symptoms.equals(medicineOrsymptoms))
				{
					bean = new MedicineBean(medicine_name,medicineId,symptoms,price,expire_date);
					list.add(bean);
				}
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
}
