<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Calm breeze login screen</title>
<link rel="stylesheet" href="css/style_login.css">
<script type="text/javascript" src="js/index_login.js"></script>
<script type="text/javascript" src="js/index1_login.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<img src="img/footer-logo1.png"> <span style="color: red">${err}</span>
			<form class="form" method="post" action="AdminHttp">
				<input type="text" placeholder="Username" name="txt_username"
					value="${user.user}"> <input type="password"
					placeholder="Password" name="txt_password" value="${user.pass }">
				<button type="submit" id="login-button" name="bt_click"
					value="Login">Login</button>
			</form>
		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</body>
</html>