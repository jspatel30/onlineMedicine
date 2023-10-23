<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="CSS/Signup.css" rel="stylesheet">
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Signup</title>
</head>
<body>
<div class="main_body">
	<div class="logo">
		<img alt="Logo" src="Images/Logo1.png" width="120px">
	</div>
	<div class="form">
	<form action="InsertCustomerServlet" method="post">
	<p>Signup</p>
		<table >
			<tr>
				<td>
					FullName:
				</td>
			</tr>
			<tr>	
				<td>
					<input type="text" class="text_field" name="name" required>
				</td>
			</tr>
			
			<tr>
				<td>
					Email:
				</td>
			</tr>
			<tr>
				<td>
					<input type="email" class="text_field" name="email" required>
				</td>
			</tr>
			
			<tr>
				<td>
					Password:
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" class="text_field" name="password" required>
				</td>
			</tr>
			
			<tr>
				<td>
					Mobile Number.:
				</td>
			</tr>
			<tr>	
				<td>
					<input type="text" class="text_field" name="contact" required>
				</td>
			</tr>
			
			<tr>
				<td>
					City:
				</td>
			</tr>
			<tr>
				<td>				
					<select name="city" required class="text_field">
						<option disabled selected>Select your City</option>
						<option value="Ahemdabad">Ahemdabad</option>
						<option value="Vadodara">Vadodara</option>
						<option value="Surat">Surat</option>
						<option value="Rajkot">Rajkot</option>
					</select>
				</td>
			</tr>
			
			<tr>
			<td></td>
			</tr>
			<tr>
				<td>
					<input type="submit"  class="btn btn-primary" value="SUBMIT">
				</td>
			</tr>
			
			<tr>
				<td>
					<a href="Login.jsp">Already Registered..? Click to Login</a>
				</td>
			</tr>
			
		</table>
	</form>
	</div>
</div>	
</body>
</html>