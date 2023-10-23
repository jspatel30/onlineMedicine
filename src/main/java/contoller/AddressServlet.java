package contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AddressBean;
import bean.OrderBean;
import dao.AddressDao;
import dao.CartDao;
import dao.OrderDao;

public class AddressServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
	 
		int userId = (int)session.getAttribute("userId");

		String verify = (String)session.getAttribute("verify");
		System.out.println("verify value in address servlet - "+verify);
		int verification = Integer.parseInt(verify);
		System.out.println("verification value in address servlet - "+verification);
		
		String name = request.getParameter("name");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		String state = request.getParameter("state");
		
		AddressBean bean = new AddressBean();
		bean.setUserId(userId);
		bean.setName(name);
		bean.setAddress_1(address1);
		bean.setAddress_2(address2);
		bean.setCity(city);
		bean.setPincode(pincode);
		bean.setState(state);
		
		int rowsAffected = 0;
		rowsAffected = AddressDao.insertAddress(bean,userId);
		if(rowsAffected!=0)
		{
			System.out.println("Address is Inserted in Database");
			
			if(verification == 1)
			{
				response.sendRedirect("OrderDataInsertionServlet");
			}
			else if(verification == 2)
			{
				response.sendRedirect("OrderAllServlet");				
			}
			else if(verification == 3)
			{				
				response.sendRedirect("DirectBuyNowServlet");				
			}
//			response.sendRedirect("OrderDataInsertionServlet");
		}
		else
		{
			System.out.println("Error in inserting Address..");
			response.sendRedirect("Customer_Address.jsp");
		}
		
	}
}