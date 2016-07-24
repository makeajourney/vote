<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
		<link href="css/writevote.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/WEB-INF/include/header.jsp" %>
				
		<div class="container">
			<form action="login.do" method="post" onsubmit="return chkformLogin();">
				<!-- Main component for a primary marketing message or call to action -->
				<div class="jumbotron">
				
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Title</span>
						<input type="text" class="form-control"  aria-describedby="basic-addon1" id="T"/>
					</div>
					<br/>
					
					<div class="form-group">
						<textarea class="form-control" rows="5" id="comment" ></textarea>
					</div>
					
					<div class="col-xs-13" >
						<input class="form-control" id="ex3" type="text" placeholder="tags" />
					</div>
					<br/>
					
					<div class="col-md-8 pull-left" id="addImgBtn">
						<!--<a class="btn btn-lg btn-primary" href="#" role="button">add images &raquo;</a>-->
						<div class="filebox col-md-8">
							<label for="ex_file">add images &raquo;</label>
							<input type="file" id="ex_file"/> 
						</div>
					</div>
					
					<div class="col-md-4" >
					    <p>
							<a class="btn btn-lg btn-primary pull-right"  role="button" id="addVoElBtn">add vote element </a>
					    </p>
					</div>
					<br/><br/><br/><br/>
					
					<label id="123">total 2</label>
					
					<div class="modal-content" id="modalContent">
					
						<div class="modal-body" id="vote">
							<input class="form-control" id="ex5" type="text" />
						</div>
					    
						<div class="modal-footer" id="vote">
							<input class="form-control" id="ex6" type="text" />
						</div>
					</div>
					 
					<nav>
						<ul class="pager">
							<li><button class="btn btn-lg btn-primary btn-block">cancel</button></li>
							<li><button class="btn btn-lg btn-primary btn-block" type="submit" id="confirmBtn" >upload</button></li>
						</ul>
					</nav>
				</form>
			</div>
		</div> <!-- /container -->
		
		<%@ include file="/WEB-INF/include/footer.jsp" %>
		<script src="js/writevote.js"></script>
	</body>
</html>