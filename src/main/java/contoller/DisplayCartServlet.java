package contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import dao.CartDao;


public class DisplayCartServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		System.out.println("UserId in cart - "+userId);
		
		ArrayList<CartBean> bean = CartDao.displayCart(userId);
		
		request.setAttribute("cart", bean);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}
}
