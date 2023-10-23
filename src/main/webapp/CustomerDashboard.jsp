<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<title>CustomerDashboard</title>
<style>
#home
{
	font-size:25px;
	background-color: #fd2363;
	border-radius: 8px;
}
</style>
</head>
<body>
<div class="navigation">	
	  <div class="navbar-logo"><img src="Images/Logo1_NavBar.png" width="75px"></div>
	<ul>
	  <li><div class="nav-element" id="home"><a href="CustomerDashboard.jsp">Home</a></div></li>
	  <li><div class="nav-element"><a href="SearchMedicine.jsp">Search Medicine</a></div></li>
	  <li><div class="nav-element"><a href="Cart.jsp">Cart</a></div></li>
	  <li><div class="nav-element"><a href="PreviousOrder.jsp">Previous Orders</a></div></li>
	  <li><div class="nav-element"><a href="About.jsp">About Medico</a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet">Logout</a></div></li>
	</ul>
</div>	

<!-- 
<div class="logo">
	<img src="Images/Logo1.png" alt="Logo">
</div>
 -->
 
<div class="content">
 	 <img src="Images/Home_Page.png" width="1300px">  
</div>


</body>
</html>