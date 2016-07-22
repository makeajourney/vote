<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
		<link href="css/votecontents.css" rel="stylesheet"/>
	</head>
	<body>
		<%@ include file="/WEB-INF/include/header.jsp" %>
	    <!-- Begin page content -->
	    <div class="container">
		    <div class="main">
		    	<div class="page-header">
		    		<h2>${article.title }</h2>
					<div class="date">${article.updateTime }</div>
				</div>
				<img src="http://imgnews.naver.net/image/215/2015/08/21/A201508210041_1_99_20150821103503.jpg?type=w540"/>
				<p class="lead">
					${article.content }
				</p>
				<div class="tags">
					<p><a>#expensive</a> <a>#car</a> <a>#please</a> <a>#choose</a> <a>#one</a></p>
				</div>
				<div class="vote">
					<div class="item">
			    		<div class="item1">BMW</div>
			    		<div class="itemnum">3<br></div>
			    	</div>
			    	<div class="item">
			    		<div class="item2">Mercedes-Benz</div>
			    		<div class="itemnum">37<br></div>
			    	</div>
			    	<div class="item">
			    		<div class="item3">LAND ROVER</div>
			    		<div class="itemnum">127<br></div>
			    	</div>
			    	<div class="item">
			    		<div class="item4">BENTLY</div>
			    		<div class="itemnum">28</div>
			    	</div>
		    		<button class="votebtn">VOTE!!</button>
				</div>
			</div>
			<div class="comment">
	    		<form class="commentform" action="">
	    			<input type="checkbox" class="checked"> suggest the vote element</input>
	    			<input type="text" class="sgbox" placeholder=" vote element"/><br>
					<input type="text" class="cbox"/>
					<button type="submit" class="cbtn">Submit</button>
	    		</form>
	    	</div>
	    	
	    	<c:choose>
				<c:when test="${fn:length(comments) > 0}">
					<c:forEach items="${comments }" var="comment">
						<div class="comment2">
					    	<div>
					    		<p class="username">${comment.userName}</p>
					    		<div class="date">${comment.updateDate }</div>
					    	</div>
					    	<div>
					    		<p>${comment.context }</p>
					    	</div>
					    	<c:if test="${comment.userNo eq user.no}">
					    	
						    	<div class="cbtn3">
						    		<button class="cbtn2 edit">edit</button>
						    		<button class="cbtn2 delete">delete</button>
						    	</div>
					    	</c:if>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>입력된 댓글이 없습니다.</p>
				</c:otherwise>
			</c:choose>
			<div class="comment2">
		    	<div><p class="username">some_user_2</p>
		    		<div class="date">2016-07-21 14:46</div>
					<div><p>I want to buy Chrysler.</p>
					</div>
					<div>Suggest the vote element <span class="sgitem">Chrysler</span>
						<div class="cbtn3">
							<button class="cbtn2 edit">edit</button>
							<button class="cbtn2 delete">delete</button>
						</div>
	    			</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/include/footer.jsp" %>
		<script src="js/votecontents.js"></script>
	</body>
</html>
