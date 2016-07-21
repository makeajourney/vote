<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
		<link href="css/main.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/WEB-INF/include/header.jsp" %>
				
		
		<div class="container">
			
			<!-- Main component for a primary marketing message or call to action -->
			<div class="jumbotron">
				
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">Title</span>
					<input type="text" class="form-control"  aria-describedby="basic-addon1">
				</div>
				<br/>
				
				<div class="form-group">
					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
				
				<div class="col-xs-13" >
					<input class="form-control" id="ex3" type="text" placeholder="tags">
				</div>
				
				<br/>
				
				<div class="col-md-8 pull-left" id="addImgBtn">
					<p>
						<a class="btn btn-lg btn-primary" href="#" role="button">add images &raquo;</a>
					</p>
				</div>
				
				<p>
					<a class="btn btn-lg btn-primary pull-right" href="#" role="button" id="addVoElBtn">add vote element </a>
				</p>
				
				<br/><br/><br/>
				
				<div class="modal-content">
				  
					<div class="modal-body" id="vote">
						<input class="form-control" id="ex3" type="text" placeholder="1">
					</div>
					<div class="modal-footer" id="vote">
						<input class="form-control" id="ex3" type="text" placeholder="2">
					</div>
				
				</div>
			  
			</div>
			
		</div> <!-- /container -->
		
		<nav>
		  <ul class="pager">
		    <li><a >cancel</a></li>
		    <li><a >upload</a></li>
		  </ul>
		</nav>

		<%@ include file="/WEB-INF/include/footer.jsp" %>
	</body>
</html>