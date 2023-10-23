package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

public class CustomerLoginServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int userId = -2;
		userId =  CustomerDao.customerLoginCredentials(email, password);
		System.out.println(userId);
		if(userId == -1)
		{
			response.sendRedirect("Admin_Panel.jsp");
		}
		else if(userId == -2)
		{
			System.out.println("Login Failed");
			request.setAttribute("error", "Username OR Password is incorrect..!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			System.out.println("Login Successfull");
			response.sendRedirect("CustomerDashboard.jsp");
		}
	}

}
