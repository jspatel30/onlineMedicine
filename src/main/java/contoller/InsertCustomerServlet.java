package contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerBean;
import dao.CustomerDao;

public class InsertCustomerServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CustomerBean data = new CustomerBean();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String city = request.getParameter("city");
		
		data.setName(name);
		data.setEmail(email);
		data.setPassword(password);
		data.setContact(contact);
		data.setCity(city);
		data.setState("Gujarat");
		int rowsAffected = 0;
		rowsAffected = CustomerDao.insertCustomer(data);
		if(rowsAffected>0)
		{
			System.out.println("Data is Successfully inserted..!");
			response.sendRedirect("Login.jsp");
		}
		else
		{
			response.sendRedirect("Customer_Signup.jsp");
		}
	}
}
