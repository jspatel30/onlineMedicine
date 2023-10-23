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

public class BuyNowServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
//		int userId = (int)session.getAttribute("userId");
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));
		String medicineName = request.getParameter("medicineName");
		String medicinePrice = request.getParameter("medicinePrice");
		String quantity = "1";
		String verify = request.getParameter("verify");//3
		
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = currentDate.format(formatter);
		
		session.setAttribute("medicineId", medicineId);
		session.setAttribute("medicineName", medicineName);
		session.setAttribute("medicinePrice", medicinePrice);
		session.setAttribute("quantity", quantity);
		session.setAttribute("date", date);
		session.setAttribute("verify", verify);
		
//		request.setAttribute("verify", verify);
		request.getRequestDispatcher("Customer_Address.jsp").forward(request, response);

	}

}
