<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dao.OrderDao" import = "bean.OrderBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<link href="CSS/ShowAllMedicine.css" rel="stylesheet">
<link href="CSS/OrderSuccess.css" rel="stylesheet">
<body>
<div class="navigation">	
	<ul>
	  <li><div class="nav-element"><a href="CustomerDashboard.jsp">Home</a></div></li>
<!--  <li><div class="search"><input type="text" name="search" placeholder="Search Medicine"></div></li>  -->
	  <li><div class="nav-element"><a href="SearchMedicine.jsp">Search Medicine</a></div></li>
	  <li><div class="nav-element"><a href="Cart.jsp">Cart</a></div></li>
	  <li><div class="nav-element"><a href="PreviousOrder.jsp">Previous Orders</a></div></li>
	  <li><div class="nav-element"><a href="About.jsp">About Medico</a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet">Logout</a></div></li>
	</ul>
</div>	
<% 
		int userId = (int)request.getAttribute("userId");
		int medicineId = (int)request.getAttribute("medicineId");
		String medicineName = (String)request.getAttribute("medicineName");
		String quantity = (String)request.getAttribute("quantity");
		String medicinePrice = (String)request.getAttribute("medicinePrice");
		String symptoms = (String)OrderDao.showSymptoms(userId, medicineId);
		OrderBean bean = null;
		
%>

<h1 align="center">Congratulations..! Your Order is Successfully Placed..!</h1>
<table>
	<tr>
		<th>Medicine Name</th>
		<th>Medicine Image</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Symptoms</th>
		<th>Total Amount</th>
	</tr>
	<tr>
		<td><%=medicineName %></td>	
		<td><img src="Medicine_Images/<%=medicineId%>.png" width="140px"></td>
		<td><%=medicinePrice %></td>	
		<td><%=quantity %></td>	
		<td><%=symptoms %></td>
		<td><%=Integer.parseInt(quantity)*Integer.parseInt(medicinePrice) %></td>	
	</tr>	
</table>
</body>
</html>