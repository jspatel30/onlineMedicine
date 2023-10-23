<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About</title>
<link href="CSS/Customer Dashboard.css" rel="stylesheet">
<link href="CSS/About.css" rel="stylesheet">
<style>
.upper_side
{
	position: absolute;
	left:0px;
	margin-top:54px;
	background-image: url("Images/About1.png");
	width: 100%;
	height: 550px;
}
.paragraph
{
	margin:15px;
	float:right;
	width: 540px;
	height: 530px;
}
.About
{
	color: white;
}
h3,p
{
	margin: 0;
	padding: 0;
}
p
{
	text-indent: 15px;
}
#About
{
	font-size:25px;
	background-color: #fd2363;
	border-radius: 8px;
}
</style>
</head>
<body>
<div class="navigation">	
	<div><img src="Images/Logo1_NavBar.png" width="75px"></div>
	<ul>
	  <li><div class="nav-element"><a href="CustomerDashboard.jsp">Home</a></div></li>
	  <li><div class="nav-element"><a href="SearchMedicine.jsp">Search Medicine</a></div></li>
	  <li><div class="nav-element"><a href="Cart.jsp">Cart</a></div></li>
	  <li><div class="nav-element"><a href="PreviousOrder.jsp">Previous Orders</a></div></li>
	  <li><div class="nav-element" id="About"><a href="About.jsp">About Medico</a></div></li>
	  <li><div class="nav-element"><a href="LogoutServlet">Logout</a></div></li>
	</ul>
</div>	
<div class="upper_side">
	<div class="paragraph">
 		<div class="About">
 			<h2>Welcome to Medico <br>- Your Trusted Partner in Home Medicine Delivery</h2>
 			<h3>Convenient Home Delivery:</h3><p>Say goodbye to long queues and time-consuming visits to the pharmacy. With Medico, you can have your medications delivered directly to your doorstep. Whether you are recovering from surgery, managing a chronic condition, or simply in need of a prescription refill, we've got you covered.</p>
 		<br>
 			<h3>Expertise and Safety: </h3><p>Your health is our top priority. Our team of experienced pharmacists and trained professionals carefully handle and dispense your medications, ensuring accurate dosing and maintaining the highest safety standards. We work closely with healthcare providers to guarantee that your prescriptions are filled correctly and promptly.</p>
 		<br>
 			<h3>Seamless Ordering Process: </h3><p>Our user-friendly website and mobile app make it effortless to place your medication orders. Simply upload your prescription or provide the necessary details, and we'll take care of the rest. We also offer convenient refill reminders and auto-renewal options to ensure you never run out of your essential medications.</p>
 		<br>
 			<h3>Data Privacy and Security: </h3><p>We understand the importance of confidentiality when it comes to your health information.  Your personal information and medical records are protected with the utmost care.</p>
 			
 		
 		</div>
	</div>
</div>

</body>
</html>