package contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;

public class UpdateQtyServlet extends HttpServlet 
{

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String quantity = request.getParameter("value");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int medicineId = Integer.parseInt(request.getParameter("medicineId"));
		String price = request.getParameter("price");
  
		int rowsAffected = CartDao.updateQuantityInCart(userId, medicineId, quantity,price);		 
		if(rowsAffected!=0)
		{
			System.out.println("Quantity updated");
//			request.setAttribute("reload", "true");
//			request.getRequestDispatcher("Cart.jsp").forward(request, response);
//			response.sendRedirect("Cart.jsp?reload=true");
		
			String url = "http://localhost:9797/Online%20Medical/Cart.jsp?reload=true";
	        
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        con.setRequestMethod("GET");
	 
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer responsee = new StringBuffer();
	 
	        while ((inputLine = in.readLine()) != null) {
	            responsee.append(inputLine);
	        }
	        in.close();
		}
		
		else
		{
			System.out.println("Quanatity not updated");
		}
	}

}
