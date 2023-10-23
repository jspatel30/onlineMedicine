<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.CartDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SearchMedicine</title>
<style>
#SearchMedicine
{
	font-size:25px;
	background-color: #fd2363;
	border-radius: 8px;
}
</style>
</head>
<link href="CSS/Search Medicine.css" rel="stylesheet">
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<body>

<div class="navigation">	
	 <div><img src="Images/Logo1_NavBar.png" width="75px"></div>
	<ul>
	  <li><div class="nav-element"><a href="CustomerDashboard.jsp">Home</a></div></li>
	  <li><div class="nav-element" id="SearchMedicine"><a href="SearchMedicine.jsp">Search Medicine</a></div></li>
	  <li><div class="nav-element"><a href="Cart.jsp">Cart</a></div></li>
	  <li><div class="nav-element"><a href="PreviousOrder.jsp">Previous Orders</a></div></li>
	  <li><div class="nav-element"><a href="About.jsp">About Medico</a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet">Logout</a></div></li>
	</ul>
</div>	

<div class="main_body">

<div class="form">
<form action="SearchMedicineServlet" method="post">
	<h1>Search Medicine</h1>
	<div><p class="para">Quickly find the medication you want with our Search Bar - you can search by Medicine Name OR with your Symptoms</p></div>
	<table align="center">
		<tr>
			<td class="td-text">
				Enter Medicine OR Symptoms:
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="search" placeholder="Search medicine by name OR your Symptoms">
			</td>
		</tr>
		<tr><td></td></tr>
		<tr>
			<td>
				<input type="submit" value="Search" class="submit">
			</td>
		</tr>
	</table>
</form>
</div>
<div class="image">
	<img alt="" src="Images/Search_Medicine.png" width="440px" height="442px">
</div>

</div>
</body>
</html>