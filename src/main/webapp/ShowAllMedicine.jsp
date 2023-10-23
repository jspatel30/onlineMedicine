<%@page import="dao.MedicineDao" import="java.util.ArrayList" import="bean.MedicineBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShowAllMedicine</title>
</head>
<link href="CSS/ShowAllMedicine.css" rel="stylesheet">
<link href="CSS/Admin_Panel.css" rel="stylesheet">
<body>
	<%
		ArrayList<MedicineBean> list = MedicineDao.showAllMedicine();
		MedicineBean bean = null;
	%>
	
	<div class="Menubar">
	<div class="Admin_navigation">
<h1 align="center" >MEDICO</h1>
	<ul class="admin_ul">
	  <li><div class="nav-element"><a href="Admin_Panel.jsp"><button>Dashboard</button></a></div></li>
  	  <li><div class="nav-element"><a href="ShowAllMedicine.jsp"><button>Show all Medicine</button></a></div></li>
	  <li><div class="nav-element"><a href="CheckStock.jsp"><button>Check Stock</button></a></div></li>
	  <li><div class="nav-element"><a href="AddMedicine.jsp"><button>Add Medicine</button></a></div></li>
  	  <li><div class="nav-element"><a href="CheckExpiredMedicine.jsp"><button>Check Expired Medicine</button></a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet"><button>Logout</button></a></div></li>
	</ul>
</div>	
</div>		

	<div class="content">
	<h1 align="center" class="heading">Available Medicines</h1>
	<table>
		<tr>
			<th>Medicine Name</th>
			<th>Medicine Image</th>
			<th>Available Quantity</th>
			<th>Price</th>
			<th>Expiry Date</th>
		</tr>
		
		<tr>
			<%		
				for(int i = 0;i<list.size();i++)
				{
					bean = list.get(i);
			%>
			<td><%=bean.getMedicine_Name()%> </td>
	   		<td><img src="Medicine_Images/<%=bean.getMedicineId()%>.png" width="140px"></td>
			<td><%=bean.getAvailable_qty()%> </td>
			<td><%=bean.getPrice()%> </td>
			<td><%=bean.getExpiry_date()%> </td>
		</tr>
		<%		
				}
		%>
		
	</table>
</div>

</body>
</html>