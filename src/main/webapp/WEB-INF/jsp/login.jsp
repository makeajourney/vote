<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
	</head>
	
	<body>
	
		<div class="container">
			<div class="logindiv">
			<form class="form-signin" action="login.do" method="post">
				<h2 class="form-signin-heading">VOTE YOUR OPINION</h2>
				<input type="text" id="inputId" name="id" class="form-control" placeholder="input your ID" required autofocus>
				<input type="password" id="inputPassword" name="password" class="form-control" placeholder="input your Password" required>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button><br>
				
			</form>
			<button class="btn btn-lg btn-primary btn-block2" type="button">Sign Up</button>
			</div>
		</div> <!-- /container -->
		
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<%@ include file="/WEB-INF/include/footer.jsp" %>
	</body>
</html>
