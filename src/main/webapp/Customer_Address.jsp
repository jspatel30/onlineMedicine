<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer_Address</title>
</head>
<link href="CSS/Customer_Address.css" rel="stylesheet">
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<%
//	HttpSession sessionn = request.getSession();
//	String vverify = (String)session.getAttribute("verify"); // 1 OR 3

//	String verify = request.getParameter("verify");//Order whole cart--2
//	sessionn.setAttribute("verify",verify);

%>
<body>
<div class="main_body">
<div class="navigation">	
  <div><img src="Images/Logo1_NavBar.png" width="75px"></div>
	<ul>
	  <li><div class="nav-element"><a href="CustomerDashboard.jsp">Home</a></div></li>
	  <li><div class="nav-element"><a href="SearchMedicine.jsp">Search Medicine</a></div></li>
	  <li><div class="nav-element" id="cart"><a href="Cart.jsp">Cart</a></div></li>
	  <li><div class="nav-element"><a href="PreviousOrder.jsp">Previous Orders</a></div></li>
	  <li><div class="nav-element"><a href="About.jsp">About Medico</a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet">Logout</a></div></li>
	</ul>
</div>	
<div class="logo">
		<img alt="Logo" src="Images/Logo1.png" width="120px">
	</div>
<div class="form">
<h2>Your Delivery Address</h2>
<form id = "myForm" action="AddressServlet" method="post">
	<table>
		<tr>
			<td>Full Name:</td>
		</tr>
		<tr>	
			<td>
				<input type="text" class="textfield" name="name">
			</td>
		</tr>
		<tr>
			<td>
				Address Line 1:
			</td>
		</tr>
		<tr>
			<td>
				<textarea rows="25" cols="25" class="textfield" name="address1"></textarea>
			</td>
		</tr>
		
		<tr>
			<td>
				Address Line 2:
			</td>
		</tr>
		<tr>	
			<td>
				<textarea rows="" cols="" class="textfield" name="address2"></textarea>
			</td>
		</tr>
	
		<tr>
			<td>
				City:
			</td>
		</tr>
		<tr>	
			<td>
				<input type="text" name="city" class="textfield">
			</td>
		</tr>
		
		<tr>
			<td>
				Pincode:
			</td>
		</tr>
		<tr>	
			<td>
				<input type="text" name="pincode" class="textfield">
			</td>
		</tr>
		
		<tr>
			<td>
				State:
			</td>
		</tr>
		<tr>	
			<td>
				 <select name="state"  class="textfield">
 					 <option value="">Select a state</option>
  				     <option value="Gujarat">Gujarat</option>
					  <option value="Rajasthan">Rajasthan</option>
					  <option value="Maharashtra">Maharashtra</option>
					  <option value="Delhi">Delhi</option>
					  <option value="Uttar Pradesh">Uttar-Pradesh</option>
				</select> 
			</td>
		</tr>
		
		<tr>
			<td class="submit">
				<input type="Submit" value="PROCEED">
			</td>
		</tr>
	</table>
</form>
 </div>
 </div>
 
</body>
</html>