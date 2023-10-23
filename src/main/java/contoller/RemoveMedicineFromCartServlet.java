package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;

public class RemoveMedicineFromCartServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		int rowsAffected = CartDao.removeMedicineFromCart(userId, medicineId);
		if(rowsAffected!=0)
		{
			System.out.println("Medicine deleted from cart");
			response.sendRedirect("Cart.jsp");
		}
	}

}
