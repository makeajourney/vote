<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
		<link href="css/login.css" rel="stylesheet">
	</head>
	
	<body>
		
		<div class="container">
			<div id="logindiv" class="enable">
				<form class="form-signin" action="login.do" method="post" onsubmit="return chkformLogin();">
					<h2 class="form-signin-heading">VOTE YOUR OPINION</h2>
					<input type="text" id="inputLoginId" name="id" class="form-control" placeholder="input your ID" required autofocus>
					<input type="password" id="inputLoginPassword" name="password" class="form-control" placeholder="input your Password" required>
					
					<button class="btn btn-lg btn-primary btn-block" type="submit" >Login</button><br>
					
				</form>
				<button id="signupToggle" class="btn btn-lg btn-primary btn-block2" type="button">Sign Up</button>
			</div>
			<div id="signupdiv" class="disable">
				<form class="form-signin" action="signup.do" method="post" onsubmit="return chkformSignup();">
					<h2 class="form-signin-heading">VOTE YOUR OPINION</h2>
					<input type="text" id="inputSignId" name="id" class="form-control" placeholder="input your ID" required autofocus>
					<input type="text" id="inputSignEmail" name="name" class="form-control" placeholder="input your name" required autofocus>
					<input type="password" id="inputSignPassword" name="password" class="form-control" placeholder="input your Password" required>
		
					<button class="btn btn-lg btn-primary btn-block" type="submit">Confirm</button><br>
		
					<button class="facebook" type="button">Facebook</button>
					<button class="naver" type="button">NAVER</button>
					<button class="google" type="button">google</button>
					<button class="kakao" type="button">KaKao</button>
		
				</form>
				<button id="loginToggle" class="btn btn-lg btn-primary btn-block2" type="button">Sign In</button>
			</div> 
		</div> <!-- /container -->

		<%@ include file="/WEB-INF/include/footer.jsp" %>
		<script src="js/login.js"></script>
	</body>
	
</html>
