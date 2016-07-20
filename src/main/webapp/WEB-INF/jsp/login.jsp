<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="../../favicon.ico">
		
		
		<!-- bootstrap cdn -->
		<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="http://getbootstrap.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
		
		<!-- for footer -->
		<link href="http://getbootstrap.com/examples/sticky-footer-navbar/sticky-footer-navbar.css" rel="stylesheet">
		
		<link href="css/login.css" rel="stylesheet">
		
		<script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>

		
		<title>VOTE YOUR OPINION</title>
		
	</head>
	
	<body>
	
		<div class="container">
		
			<form class="form-signin" action="login.do" method="post">
				<h2 class="form-signin-heading">VOTE YOUR OPINION</h2>
				<input type="text" id="inputId" name="id" class="form-control" placeholder="input your ID" required autofocus>
				<input type="password" id="inputPassword" name="password" class="form-control" placeholder="input your Password" required>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button><br>
				
			</form>
			<button class="btn btn-lg btn-primary btn-block2" type="button">Sign Up</button>
		</div> <!-- /container -->
		
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<%@ include file="/WEB-INF/include/footer.jsp" %>
	</body>
</html>
