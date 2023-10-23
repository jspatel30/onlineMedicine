package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MedicineBean;
import dao.MedicineDao;


public class AddMedicineServlet extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		MedicineBean mbean = new MedicineBean();
		String medicine_name = request.getParameter("medicine_name");
		String available_quantity = request.getParameter("available_qty");
		String price = request.getParameter("price");
		String expiry_date = request.getParameter("expiry_date");
		String symptomps = request.getParameter("symptomps");
		String medicine_image = request.getParameter("medicine_image");

		mbean.setMedicine_Name(medicine_name);
		mbean.setAvailable_qty(available_quantity);
		mbean.setPrice(price);
		mbean.setExpiry_date(expiry_date);
		mbean.setsymptoms(symptomps);
		mbean.setMedicine_image(medicine_image);
		
		int rowsAffected = 0;
		rowsAffected = MedicineDao.addMedicine(mbean);
		if(rowsAffected>0)
		{
			System.out.println("Data Inserted Successfully");
			response.sendRedirect("Admin_Panel.jsp");
		}
		else
		{
			System.out.println("Data insertion fails..!");
		}
	}

}
