<%@page import="bean.MedicineBean"  import="dao.MedicineDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ResultOfSearchMedicine</title>
</head>
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<link href="CSS/ResultOfSearchMedicine.css" rel="stylesheet">
<body>
<div class="navigation">	
	<ul>
	  <li><div class="nav-element"><a href="CustomerDashboard.jsp">Home</a></div></li>
	  <li><div class="nav-element"><a href="SearchMedicine.jsp">Search Medicine</a></div></li>
	  <li><div class="nav-element"><a href="Cart.jsp">Cart</a></div></li>
	  <li><div class="nav-element"><a href="PreviousOrder.jsp">Previous Orders</a></div></li>
	  <li><div class="nav-element"><a href="About.jsp">About Medico</a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet">Logout</a></div></li>
	</ul>
</div>	

<%
//	ArrayList<MedicineBean> list = (ArrayList<MedicineBean>)request.getAttribute("list");
	HttpSession sessionn = request.getSession();
	String searchMedicine = (String)session.getAttribute("searchMedicine");
//	String searchMedicine = (String)request.getAttribute("searchMedicine");
	ArrayList<MedicineBean> list = MedicineDao.searchMedicine(searchMedicine);
	MedicineBean bean = null;
%>

<table>
		<tr>
			<th>Medicine Name</th>
			<th>Medicine Image</th>
			<th>Used for</th>
			<th>Price</th>
			<th>Expiry Date</th>
			<th>Purchase</th>
			<th>Add to Cart</th>
		</tr>

		<tr>
			<%
				for(int i = 0;i<list.size();i++)
				{
					bean = list.get(i);
			%>
			<td><%=bean.getMedicine_Name() %></td>
			<td><img src="Medicine_Images/<%=bean.getMedicineId()%>.png" width="140px"></td>
			<td><%=bean.getsymptoms() %></td> 
			<td><%=bean.getPrice() %></td>
			<td><%=bean.getExpiry_date() %></td>
			<td><a href="BuyNowServlet?medicineId=<%=bean.getMedicineId()%>&medicineName=<%=bean.getMedicine_Name()%>&medicinePrice=<%=bean.getPrice()%>&verify=<%=3%>"><button>Buy now</button></a></td>
			<td><a href="AddToCartServlet?medicineId=<%=bean.getMedicineId()%>&medicineName=<%=bean.getMedicine_Name()%>&medicinePrice=<%=bean.getPrice()%>"><button>Add to cart</button></a></td>
		</tr>
		<%
				}
		%>
		
	</table>
</body>
</html>