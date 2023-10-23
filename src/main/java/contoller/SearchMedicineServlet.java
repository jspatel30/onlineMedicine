package contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MedicineBean;
import dao.MedicineDao;


public class SearchMedicineServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String searchMedicine = request.getParameter("search");
		System.out.println(searchMedicine);
		HttpSession session = request.getSession();
		session.setAttribute("searchMedicine", searchMedicine);
		request.setAttribute("searchMedicine", searchMedicine); 
		request.getRequestDispatcher("ResultOfSearchMedicine.jsp").forward(request, response);
	
		
		
	}

}
