<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="CSS/Login.css" rel="stylesheet">
</head>
<style>
body
{
	  background-image: url('Images/LoginBackground1.jpg');
      background-repeat:no-repeat;
      width:100%;
      background-size: cover;
}
</style>
<body>
<%
		HttpSession sessionn = request.getSession();
		int userId = 0;
		try
		{
			userId = (int)session.getAttribute("userId");
		}
		catch(Exception e)
		{
			userId = 0;
		}
		if(userId!=0)
		{
			response.sendRedirect("CustomerDashboard.jsp");
		}
		
	%>

	<%
		String error = (String)request.getAttribute("error");
	%>
	<div class="logo">
		<img src="Images/Logo1.png" width="160px" alt="Logo">
	</div>
	<div class="login-container">
		<h1 align="center">Login</h1>
		<form action="CustomerLoginServlet" class="form-group" method="post">
			<table align="center" >
				<tr>
					<td>
						Email ID:
					</td>
				</tr>
				<tr>	
					<td>
						<input type="email" name="email" placeholder="abc@gamil.com">
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" name="password" placeholder="*********">
					</td>
				</tr>
				<tr>
					
					<td>
						<input type="submit" value="Login">
					<%=error==null?"":error %>
					</td>
				</tr>
				<tr>
					<td>
						<a href="Customer_Signup.jsp">New User..? Click to Signup</a>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>