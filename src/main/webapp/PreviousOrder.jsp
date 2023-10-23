<%@page import="dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.ArrayList" import = "bean.OrderBean"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PreviousOrder jsp</title>
<style>
#PreviousOrders
{
	font-size:25px;
	background-color: #fd2363;
	border-radius: 8px;
}
</style>
</head>
<link href="CSS/PreviousOrder.css" rel="stylesheet">
<link href="CSS/Customer Dashboard.css" rel="stylesheet">

<body>
<div class="navigation">	
	<div><img src="Images/Logo1_NavBar.png" width="75px"></div>
	<ul>
	  <li><div class="nav-element"><a href="CustomerDashboard.jsp">Home</a></div></li>
	  <li><div class="nav-element"><a href="SearchMedicine.jsp">Search Medicine</a></div></li>
	  <li><div class="nav-element"><a href="Cart.jsp">Cart</a></div></li>
	  <li><div class="nav-element" id="PreviousOrders"><a href="PreviousOrder.jsp">Previous Orders</a></div></li>
	  <li><div class="nav-element"><a href="About.jsp">About Medico</a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet">Logout</a></div></li>
	</ul>
</div>	

<%
	HttpSession sessionn = request.getSession();
	int userId = (int)sessionn.getAttribute("userId");
	ArrayList<OrderBean> list = OrderDao.previousOrders(userId);
	OrderBean bean = null;
%>
<p>Previous Orders</p>
<table>
	<tr>
		<th>Medicine Name</th>
		<th>Medicine Image</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Total Order</th>
		<th>Date</th>
	</tr>
	<tr>
		<%
			for(int i = 0;i<list.size();i++)
			{
				bean = list.get(i);
		%>
			<td><%=bean.getMedicineName() %></td>
			<td><img src="Medicine_Images/<%=bean.getMedicineId()%>.png" width="140px"></td>
			<td><%=bean.getQuantity() %></td>
			<td><%=bean.getAmount() %></td>
			<td><%=bean.getTotalAmount() %></td>
			<td><%=bean.getDate() %></td>
	</tr>
		<%} %>
</table>
</body>
</html>