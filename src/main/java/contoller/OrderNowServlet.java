package contoller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import dao.OrderDao;

public class OrderNowServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//This servlet will be called when user press BUY NOW in cart.jsp
		HttpSession session = request.getSession();
		OrderBean bean = new OrderBean(); 
		int userId = Integer.parseInt(request.getParameter("userId"));
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));
		String medicineName = request.getParameter("medicineName");
		String quantity = request.getParameter("quantity");
		String amount = request.getParameter("amount");
		
		String verify = request.getParameter("verify");// 1
		System.out.println("OrderNowServlet Verify Value - "+verify);
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = currentDate.format(formatter);

		session.setAttribute("medicineId", medicineId);
		session.setAttribute("medicineName", medicineName);
		session.setAttribute("quantity", quantity);
		session.setAttribute("amount", amount);
		session.setAttribute("date", date);
		
		session.setAttribute("verify", verify);//1
	
		response.sendRedirect("Customer_Address.jsp");
		
//		bean.setUserId(userId);
//		bean.setMedicineId(medicineId);
//		bean.setMedicineName(medicineName);
//		bean.setQuantity(quantity);
//		bean.setAmount(amount);
//		bean.setDate(date);
		
		//OrderDao.insertOrderData(bean);
//		if(rowsAffected!=0)
//		{
//			request.setAttribute("userId", userId);
//			request.setAttribute("medicineId", medicineId);			
//			request.setAttribute("medicineName", medicineName);			
//			request.setAttribute("quantity", quantity);			
//			request.setAttribute("amount", amount);			
//			request.setAttribute("date", date);			
//			System.out.println("Order Successfully Placed..!");
//			request.getRequestDispatcher("OrderSuccess.jsp").forward(request, response);
//		}
//		else
//		{
//			request.setAttribute("notAvailable", "Sorry, but that much quantity is not available");
//			request.getRequestDispatcher("Cart.jsp").forward(request, response);
//			System.out.println("Order Not Placed");
//		}
	}
}
