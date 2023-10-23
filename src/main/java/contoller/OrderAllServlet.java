package contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import dao.CartDao;
import dao.OrderDao;

public class OrderAllServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		 
		int userId = (int)session.getAttribute("userId");
		
		ArrayList<OrderBean> symptoms = OrderDao.showSymptomsforAllMedicine(userId);
		String totalAmount = CartDao.displayCartTotal(userId);
		ArrayList<OrderBean> list = OrderDao.orderAllInCart(userId);
		OrderBean bean = null; 
		OrderBean symptm = null; 
		request.setAttribute("symptoms", symptoms);
		request.setAttribute("totalAmount", totalAmount);
		request.setAttribute("list", list); 
		request.getRequestDispatcher("OrderAllSuccess.jsp").forward(request, response);
	
	}

}
