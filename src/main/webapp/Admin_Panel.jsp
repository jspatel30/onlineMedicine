<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="CSS/Admin_Panel.css" rel="stylesheet">
<title>Admin_Panel</title>
</head>
<body>

<div class="display">
<div class="Admin_navigation">
<h1 align="center">MEDICO</h1>
	<ul class="admin_ul">
	  <li><div class="nav-element"><a href="Admin_Panel.jsp"><button>Dashboard</button></a></div></li>
  	  <li><div class="nav-element"><a href="ShowAllMedicine.jsp"><button>Show all Medicine</button></a></div></li>
	  <li><div class="nav-element"><a href="CheckStock.jsp"><button>Check Stock</button></a></div></li>
<!--  <li><div class="nav-element"><a href="#about"><button>Soon get Out of Stock</button></a></div></li>  -->	
	  <li><div class="nav-element"><a href="AddMedicine.jsp"><button>Add Medicine</button></a></div></li>
  	  <li><div class="nav-element"><a href="CheckExpiredMedicine.jsp"><button>Check Expired Medicine</button></a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet"><button>Logout</button></a></div></li>
	</ul>
</div>
<div class="DasboardText">
<h1 style="color:black">Dashboard</h1>
</div>
<div class="graphs">
	<div class="graph1">
	  <img src="Images/Graph1.jpg" width="380px">
	</div>
	<div class="graph2">
		<img src="Images/Graph2.jpg" width="380px">
	</div>
	<div class="graph3"></div>

</div>

</div>
</body>
</html>