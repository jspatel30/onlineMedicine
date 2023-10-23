package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import dao.CartDao;


public class AddToCartServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		CartBean cbean = new CartBean();
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));
		String medicineName = request.getParameter("medicineName");
		String medicinePrice = request.getParameter("medicinePrice");
		System.out.println(medicineName);
		
		System.out.println("medicinePrice-- "+medicinePrice);
		
		int quantity = CartDao.updateQuantity(userId, medicineId);
		if(quantity == 0)
		{
			cbean.setMedicineId(medicineId);
			cbean.setUserId(userId);
			cbean.setMedicineName(medicineName);
			cbean.setAmount(medicinePrice);
			cbean.setQuantity("1");
			cbean.setTotalCartAmount("1");
			System.out.println("cbean.getTotalCartAmount() --  "+cbean.getTotalCartAmount());
			int rowsAffected = CartDao.addToCart(cbean,userId,medicineId);
			if(rowsAffected!=0)
			{
				response.sendRedirect("ResultOfSearchMedicine.jsp");
			}
		}		
		else
		{
			response.sendRedirect("ResultOfSearchMedicine.jsp");			
		}
		
	}

}
