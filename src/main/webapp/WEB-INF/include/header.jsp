<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">	
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/main.do' />">vote your opinion</a>
		</div>
		
		<ul class="nav navbar-nav">
			<li><a href="#about" data-toggle="collapse" data-target="#demo"><img src="https://d30y9cdsu7xlg0.cloudfront.net/png/2506-200.png" id="imgs"></a></li>
		</ul>
		
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav  navbar-right">	
				<li><a href="<c:url value='/showWriteVoteWindow.do' />" id="new_vote">new vote</a></li>
								
				<li class="dropdown pull-right">
				
				
					<c:choose>
						<c:when test="${!empty user.name }">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								${user.name}
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">My Profile</a></li>
								<li><a href="<c:url value='/showMyVoteList.do' />" >My Article</a></li>      
								<li><a href="<c:url value='/logout.do' />">Logout</a></li>     
							</ul>
		                </c:when>
						<c:otherwise>
							<a href="<c:url value='/login.do' />" role="button" aria-haspopup="true" aria-expanded="false">
								Login
							</a>
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div><!--/.nav-collapse -->
	</div>
</nav>

<!-- Begin page content -->
<div class="container">
  <div id="demo" class="collapse">
  	<input class="form-control" id="focusedInput" type="text" placeholder="search">
  </div>
</div>