package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.OrderBean;
import dao.OrderDao;


public class DirectBuyNowServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		OrderBean bean = new OrderBean();
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		int medicineId = (int)session.getAttribute("medicineId");
		String medicineName = (String)session.getAttribute("medicineName");
		String medicinePrice = (String)session.getAttribute("medicinePrice");
		String quantity = (String)session.getAttribute("quantity");
		String date = (String)session.getAttribute("date");
		
		bean.setUserId(userId);
		bean.setMedicineId(medicineId);
		bean.setMedicineName(medicineName);
		bean.setAmount(medicinePrice);
		bean.setQuantity(quantity);
		bean.setDate(date);
		
		int rowsAffected = 0;
		rowsAffected = OrderDao.buyNow(bean); 
		if(rowsAffected>0)
		{
			request.setAttribute("userId", userId);
			request.setAttribute("medicineId", medicineId);
			request.setAttribute("medicineName", medicineName);
			request.setAttribute("medicinePrice", medicinePrice);
			request.setAttribute("quantity",quantity);
			request.getRequestDispatcher("OrderSuccessBuyNow.jsp").forward(request, response);
		}
	}

}
