<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.CartBean" import="dao.CartDao" import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
	
<%
	String reload = (String)request.getParameter("reload");
	if(reload!=null && reload.equals("true"))
	{
%>
		<meta charset="UTF-8" http-equiv="refresh" content="0;url=Cart.jsp">		
	<%} %>
	
<title>Cart</title>
<style>
#cart
{
	font-size:25px;
	background-color: #fd2363;
	border-radius: 8px;
}
</style>
</head>
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<link href="CSS/ShowAllMedicine.css" rel="stylesheet">
<link href="CSS/Cart.css" rel="stylesheet">

<script>
function updateQuantity(i,userId,medicineId,amount) 
{
	var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "UpdateQtyServlet", true); // replace YourServletName with your servlet name
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var value = document.getElementById("inputValue_"+i).value; // get the value from input field
    xhttp.send("value=" + value+"&userId="+userId+"&medicineId="+medicineId+"&price="+amount); // send the request to servlet with the value as parameter
    window.location.href = "http://localhost:9797/Online%20Medical/Cart.jsp?reload=true"; //To reload the Page
}
</script>

<body>

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

<%
//	ArrayList<CartBean> list = (ArrayList<CartBean>)request.getAttribute("cart");
	HttpSession sessionn = request.getSession();
	int userId = (int)sessionn.getAttribute("userId");
	ArrayList<CartBean> list = CartDao.displayCart(userId);
	CartBean bean = null;
	String totalCartAmount = CartDao.displayCartTotal(userId);
	String notAvailable = (String)request.getAttribute("notAvailable");
%>
	<%	
		if(list.size()==0)
		{
		
	%>	
		<div class="empty_cart">
			<h1 align="center">Your Cart is Empty</h1>
		</div>
	<%
		}
	else
	{
	%>
	<h1 align="center">Your cart</h1>
	
<table>
	<tr>
		<th>Medicine Name</th>
		<th>Medicine Image</th>
		<th>Symptoms</th>
		<th>Expiry Date</th>
		<th>Medicine Price</th>
		<th>Quantity</th>
		<th>Buy Now</th>	
	</tr>
	<tr>
			<%
				for(int i = 0;i<list.size();i++)
				{
					bean = list.get(i);
			%>
			<td><%=bean.getMedicineName() %></td>
			<td><img src="Medicine_Images/<%=bean.getMedicineId()%>.png" width="140px"></td>
			<td><%=bean.getSymptoms() %></td>
			<td><%=bean.getExpiry_date()%></td>
			<td><%=bean.getAmount() %></td>
			<td><input type="number" name="qty_change" id="inputValue_<%=i%>" value=<%=bean.getQuantity()%> min="0" max="50" onchange= "updateQuantity(<%=i%>,<%=bean.getUserId()%>,<%=bean.getMedicineId()%>,<%=bean.getAmount()%>)"><div class="delete_img"><a href="RemoveMedicineFromCartServlet?medicineId=<%=bean.getMedicineId() %>&userId=<%=bean.getUserId()%>"><img src="Images/bin.png"></a></div></td> 
			<td><div class="buy_now"><a href="OrderNowServlet?medicineId=<%=bean.getMedicineId()%>&userId=<%=userId%>&medicineName=<%=bean.getMedicineName()%>&quantity=<%=bean.getQuantity()%>&amount=<%=bean.getAmount()%>&verify=<%=1%>"><button><b>Buy Now</b></button></a></div></td>
			
		</tr> 
		<%
				}
		%>
</table>
	
<div class="totalcart">
	<h2><%=notAvailable==null?"":notAvailable%></h2>
	<h2>Total Cart Amount : <%=totalCartAmount==null?"":totalCartAmount%></h2>
	<div class="buy_now"><a href="OrderWholeCart_SetVerifyValue?&verify=<%=2%>"><button><b>Order Now</b></button></a></div>
</div>
<%
	}
%>
</body>
</html>