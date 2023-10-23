package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Util.DBConnection;
import bean.CartBean;
import bean.MedicineBean;

public class CartDao 
{
	
	public static int addToCart(CartBean bean,int UserId , int MedicineId)
	{
//		Connection conn = DBConnection.getConnection();
//		int rowsAffected = 0;
//		String selectQuery = "Select userId,medicineId,Quantity,Medicine_Amount,TotalCartAmount from cart";
//		try
//		{
//			Statement stmt = conn.createStatement();
//			ResultSet rs = null;
//			rs = stmt.executeQuery(selectQuery);
//			boolean update = false;
//			String quantity = null;
//			String TotalCartAmount = null;
//			String price = null;
//			int cartTotal = 0;
//			while(rs.next())
//			{
//				int userId = rs.getInt(1);
//				int medicineId = rs.getInt(2); 
//				quantity = rs.getString(3);
//				price = rs.getString(4);
//				TotalCartAmount = rs.getString(5);
//				
//				if(UserId==userId && MedicineId==medicineId)
//				{					
//					update = true;
//					break;
//				}
//			}
//				if(update)
//				{
//					int qty = Integer.parseInt(quantity)+1;
//					String qtyy = Integer.toString(qty);
//					String updateQuery = "Update cart SET Quantity = "+qtyy+"  where userId = "+UserId+" and medicineId = "+MedicineId+"";
//					try
//					{
//						stmt = conn.createStatement();
//						rowsAffected = stmt.executeUpdate(updateQuery);
//						System.out.println("Cart Row Updated");
//					}
//					catch (SQLException e) 
//					{
//						e.printStackTrace();
//					}
		
		
		
		
		
		
//					TotalCartAmount = Integer.toString(cartTotal);
					
//					String cartAmountQuery = "Select sum(Quantity*Medicine_Amount) from cart where userId = "+UserId+"";
//					ResultSet rs1 = null;
//					Statement stmt1 = null;
////					int rowsAffected = 0;
//					try 
//					{
//						stmt1 = conn.createStatement();
//						rs1 = stmt1.executeQuery(cartAmountQuery);	
//						String totalCartAmount = null;
//						while(rs1.next())
//						{
//							totalCartAmount = rs1.getString(1);
//						}
////						 rowsAffected = Integer.parseInt(totalCartAmount);
//						 String insertQuery = "Update cart SET  TotalCartAmount = "+totalCartAmount+" where userId = "+UserId+"";
//						 Statement stmt2 = null;
//						 try
//							{
//								stmt2 = conn.createStatement();
//								rowsAffected = stmt2.executeUpdate(insertQuery);
//								System.out.println("Total cart amount Row Updated");
//							}
//							catch (SQLException e) 
//							{
//								e.printStackTrace();
//							}
//					
//					
//					} 
//					catch (SQLException e) 
//					{
//						e.printStackTrace();
//					}
//					return rowsAffected; // It will return the Total amount of Cart
					
//				}
//				else
//				{
					Connection conn = DBConnection.getConnection();
					String insertQuery = "Insert into cart (UserId,MedicineId,MedicineName,Quantity,Medicine_Amount,TotalCartAmount) VALUES(?,?,?,?,?,?)";
					int rowsAffected = 0;
					try 
					{
						PreparedStatement pstmt = conn.prepareStatement(insertQuery);
						pstmt.setInt(1, bean.getUserId());
						pstmt.setInt(2, bean.getMedicineId());
						pstmt.setString(3, bean.getMedicineName());
						pstmt.setString(4, bean.getQuantity());
						pstmt.setString(5, bean.getAmount());
						pstmt.setString(6, bean.getTotalCartAmount());
						System.out.println("Total cart amount in CartDao - "+bean.getTotalCartAmount());
						rowsAffected = pstmt.executeUpdate();
					}
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
//			}
//		}
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
		return rowsAffected;
	}

	
	public static int updateQuantity(int UserId,int MedicineId)
	{
		Connection conn = DBConnection.getConnection();
		int rowsAffected = 0;
		String selectQuery = "Select userId,medicineId,Quantity,Medicine_Amount,TotalCartAmount from cart";
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(selectQuery);
			boolean update = false;
			String quantity = null;
			String TotalCartAmount = null;
			String price = null;
			int cartTotal = 0;
			while(rs.next())
			{
				int userId = rs.getInt(1);
				int medicineId = rs.getInt(2); 
				quantity = rs.getString(3);
				price = rs.getString(4);
				TotalCartAmount = rs.getString(5);
				
				if(UserId==userId && MedicineId==medicineId)
				{					
					update = true;
					break;
				}
			}
				if(update)
				{
					int qty = Integer.parseInt(quantity)+1;
					int amnt = Integer.parseInt(price);
					int total = qty*amnt;
					String qtyy = Integer.toString(qty);
					String totalAmount = Integer.toString(total);
				
					String updateQuery = "Update cart SET Quantity = "+qtyy+" , TotalCartAmount = "+totalAmount+" where userId = "+UserId+" and medicineId = "+MedicineId+"";
					try
					{
						stmt = conn.createStatement();
						rowsAffected = stmt.executeUpdate(updateQuery);
						System.out.println("Cart Row Updated");
					}
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}	
		}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
		return rowsAffected;
			}
	
	
	
	
	public static ArrayList<CartBean> displayCart(int userId)
	{
		ArrayList<CartBean> list = new ArrayList<CartBean>();
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select cart.userId,cart.medicineId,cart.medicineName,cart.quantity,cart.Medicine_Amount,medicine.expiry_date,medicine.symptoms,cart.TotalCartAmount  from cart,medicine where cart.medicineId = medicine.medicineId and userId = "+userId+"";
		CartBean bean = null;
		
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				int cartUserId = rs.getInt(1);
				int cartMedicineId = rs.getInt(2);
				String medicine_name = rs.getString(3);
				String quantity = rs.getString(4);
				String price = rs.getString(5);
				String expiry_date = rs.getString(6);
				String symptoms = rs.getString(7);
				String TotalCartAmount = rs.getString(8); 
				bean = new CartBean(cartUserId,cartMedicineId,medicine_name,quantity,price,expiry_date,symptoms,TotalCartAmount);
				list.add(bean);
			}
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static String displayCartTotal(int userId)
	{
	
		Connection conn = DBConnection.getConnection();
		String selectQuery = "Select sum(TotalCartAmount) from cart where userId = "+userId+"";
//		String cartAmountQuery = "Select userId ,Quantity , Medicine_Amount , (Quantity*Medicine_Amount), sum(Quantity*Medicine_Amount) from cart where userId = "+UserId+"";
//		int amount = Integer.parseInt(price);					
//		cartTotal = qty*amount;
		String totalCartAmount = null;
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				totalCartAmount = rs.getString(1);
			}
		
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return totalCartAmount;
		
	}
	
	public static int updateQuantityInCart(int userId,int medicineId,String quantity,String price)
	{
		Connection conn = DBConnection.getConnection();
		
		String updateQuery = "Update cart SET quantity = "+quantity+" , TotalCartAmount = "+Integer.valueOf(price) * Integer.valueOf(quantity)+" where userId = "+userId+" and medicineId = "+medicineId+"";
		int rowsAffected = 0;
		try 
		{
			Statement stmt = conn.createStatement();
			rowsAffected = stmt.executeUpdate(updateQuery);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	 public static int removeMedicineFromCart(int userId,int medicineId)
	 {
		 Connection conn = DBConnection.getConnection();
		 String deleteQuery = "Delete from cart where userId = "+userId+" and medicineId = "+medicineId+"";
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
	 
	 public static int removeAllMedicineFromCart(int userId)
	 {
		 Connection conn = DBConnection.getConnection();
		 String deleteQuery = "Delete from cart where userId = "+userId+" ";
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
}
