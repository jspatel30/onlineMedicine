package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import dao.OrderDao;


public class OrderDataInsertionServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		OrderBean bean = new OrderBean();
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		int medicineId = (int)session.getAttribute("medicineId");
		String medicineName = (String)session.getAttribute("medicineName");
		String quantity = (String)session.getAttribute("quantity");
		String amount = (String)session.getAttribute("amount");
		String date = (String)session.getAttribute("date");
		
		bean.setUserId(userId);
		bean.setMedicineId(medicineId);
		bean.setMedicineName(medicineName);
		bean.setQuantity(quantity);
		bean.setAmount(amount);
		bean.setDate(date);
		
		int rowsAffected = OrderDao.insertOrderData(bean);
		if(rowsAffected!=0)
		{
			request.setAttribute("userId", userId);
			request.setAttribute("medicineId", medicineId);			
			request.setAttribute("medicineName", medicineName);			
			request.setAttribute("quantity", quantity);			
			request.setAttribute("amount", amount);			
			request.setAttribute("date", date);			
			System.out.println("Order Successfully Placed..!");
			request.getRequestDispatcher("OrderSuccess.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("notAvailable", "Sorry, but that much quantity is not available");
			request.getRequestDispatcher("Cart.jsp").forward(request, response);
			System.out.println("Order Not Placed");
		}
	}

}
