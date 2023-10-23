<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Medicine</title>
</head>
<link href="CSS/Admin_Panel.css" rel="stylesheet">
<link href="CSS/AddMedicine.css" rel="stylesheet">
<body>

<div class="Admin_navigation">
<h1 align="center">MEDICO</h1>
	<ul class="admin_ul">
	  <li><div class="nav-element"><a href="Admin_Panel.jsp"><button>Dashboard</button></a></div></li>
  	  <li><div class="nav-element"><a href="ShowAllMedicine.jsp"><button>Show all Medicine</button></a></div></li>
	  <li><div class="nav-element"><a href="CheckStock.jsp"><button>Check Stock</button></a></div></li>
	  <li><div class="nav-element"><a href="AddMedicine.jsp"><button>Add Medicine</button></a></div></li>
  	  <li><div class="nav-element"><a href="CheckExpiredMedicine.jsp"><button>Check Expired Medicine</button></a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet"><button>Logout</button></a></div></li>
	</ul>	
</div>
 
 
<div class="table">
<h1 align="center">Add Medicine</h1>
<form action="AddMedicineServlet" method="post">
	<table align="center">
		<tr>
			<td>
				Medicine Name:
			</td>
			<td>
				<input type="text" name="medicine_name">
			</td>
		</tr>
		
		<tr>
			<td>
				Medicine Image:
			</td>
			<td>
				<input type="file" name="medicine_image">
			</td>
		</tr>
		
		<tr>
			<td>
				Quantity:
			</td>
			<td>
				<input type="text" name="available_qty">
			</td>
		</tr>
		
		<tr>
			<td>
				Price:
			</td>
			<td>
				<input type="text" name="price">
			</td>
		</tr>
		
		<tr>
			<td>
				Symptomps:
			</td>
			<td>
				<input type="text" name="symptomps">
			</td>
		</tr>
		
		<tr>
			<td>
				Expiry Date:
			</td>
			<td>
				<input type="date" name="expiry_date">
			</td>
		</tr>
		
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" value="Add Medicine">
			</td>
		</tr>
	</table>
</form>
	</div>
</body>
</html>