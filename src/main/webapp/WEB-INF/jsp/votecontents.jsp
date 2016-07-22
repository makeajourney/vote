<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
		<link href="css/votecontents.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/WEB-INF/include/header.jsp" %>

	    <!-- Begin page content -->
	    <div class="container">
	    <div class="main">
	      <div class="page-header">
	        <h2>${article.title }</h2>
	        <div class="date">${article.updateDate }</div>
	      </div>
	      <img src="http://imgnews.naver.net/image/215/2015/08/21/A201508210041_1_99_20150821103503.jpg?type=w540">
	     <p class="lead">${article.content }</p>
	     <div class="tags">
	    	<p><a>#expensive</a> <a>#car</a> <a>#please</a> <a>#choose</a> <a>#one</a></p>
	    </div>
	    <div class="vote">
	    	<div class="item item1">BMW<br></div>
	    	<div class="item item2">Mercedes-Benz<br></div>
	    	<div class="item item3">LAND ROVER<br></div>
	    	<div class="item item4">BENTLY</div>
	    	<button class="votebtn">VOTE!!</div></button>
	    </div>
	    </div>
	    <!-- 댓글 작성 폼 -->
	    <div class="comment">
	    	<form class="commentform">
	    	<input type="checkbox"> suggest the vote element <input type="text" class="sgbox" placeholder=" vote element"><br>
	    	<input type="text" class="cbox"> <button type="submit" class="cbtn">Submit</button>
	    	</form>
	    </div>
	    <!-- 댓글 보기 -->
	    
	    <c:choose>
			<c:when test="${fn:length(comments) > 0}">
				<c:forEach items="${comments }" var="comment">
					<div class="comment2">
				    	<div>
				    		<p class="username">${comment.username}</p>
					    	<div class="date">
					    		${comment.updateDate }
					    	</div>
					    </div>
					    <div>
					    	<p>${comment.context }</p>
					    </div>
				    	<div class="cbtn3">
				    		<button class="cbtn2 edit">edit</button>
				    		<button class="cbtn2 delete">delete</button>
				    	</div>
				    </div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<p>조회된 결과가 없습니다.</p>
			</c:otherwise>
		</c:choose>
	    <div class="comment2">
	    	<div><p class="username">some_user_1</p>
	    	<div class="date">2016-07-21 14:24</div></div>
	    	<div><p>I want to buy LAND ROVER.</p></div>
	    	<div class="cbtn3"><button class="cbtn2 edit">edit</button> <button class="cbtn2 delete">delete</button></div>
	    </div>
	    <div class="comment2">
	    	<div><p class="username">some_user_2</p>
	    	<div class="date">2016-07-21 14:46</div></div>
	    	<div><p>I want to buy Chrysler.</p></div>
	    	<div>Suggest the vote element <span class="sgitem">Chrysler</span><div class="cbtn3"><button class="cbtn2 edit">edit</button> <button class="cbtn2 delete">delete</button></div></div>
	    	
	    </div>
	    </div>
	
					
		<%@ include file="/WEB-INF/include/footer.jsp" %>
	</body>
</html>
  </body>
</html>
