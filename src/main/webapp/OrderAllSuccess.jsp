<%@page import="dao.CartDao"%>
<%@page import="bean.OrderBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderAllSuccess jsp</title>
</head>
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<link href="CSS/ShowAllMedicine.css" rel="stylesheet">
<link href="CSS/OrderAllSuccess.css" rel="stylesheet">
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
	HttpSession sessionn = request.getSession();
	int userId = (int)session.getAttribute("userId");
	ArrayList<OrderBean> symptoms = (ArrayList<OrderBean>)request.getAttribute("symptoms");
	String totalAmount = (String)request.getAttribute("totalAmount");
	ArrayList<OrderBean> list = (ArrayList<OrderBean>)request.getAttribute("list");
	OrderBean bean = null; 
	OrderBean symptm = null; 
%>
<h1>Your Order Successfully Placed..!</h1>
<table>
	<tr>
		<th>Medicine Name</th>
		<th>Medicine Image</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Symptoms</th>
	</tr>
	<tr>
		<%
			for(int i = 0;i<list.size();i++)
			{
				bean = list.get(i);
				symptm = symptoms.get(i);
			%>
		<td><%=bean.getMedicineName() %></td>
		<td><img src="Medicine_Images/<%=bean.getMedicineId()%>.png" width="140px"></td>
		<td><%=bean.getAmount() %></td>
		<td><%=bean.getQuantity() %></td>
		<td><%=symptm.getSymptoms()%></td>
	</tr>
		<%
			}
		%>
</table>
<div class="totalCartAmount">
	<h2><%="Your Order Total Amount is "+totalAmount%></h2>
</div>
</body>
</html>