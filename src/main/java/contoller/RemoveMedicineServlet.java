package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicineDao;


public class RemoveMedicineServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int mid = Integer.parseInt(request.getParameter("mid"));
		int rowsAffected = 0;
		
		rowsAffected = MedicineDao.removeMedicine(mid);
		if(rowsAffected!=0)
		{
			System.out.println("Medicine Deleted Successfully..!");
			response.sendRedirect("CheckExpiredMedicine.jsp");
		}
		else
		{
			System.out.println("Medicine not Deleted");
		}
	}
}
