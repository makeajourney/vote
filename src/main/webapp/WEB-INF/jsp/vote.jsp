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
		
		<div class=container>
			<p>글 번호 : ${article.no }</p>
			<p>제목 : ${article.title }</p>
			<p>글쓴이 : ${article.username }</p>
			<p>작성시각 : ${article.createTime }</p>
			<p>조회수 : ${article.hitCount }</p>
			<p>내용 : ${article.content }</p>
		</div>
		
		<%@ include file="/WEB-INF/include/footer.jsp" %>
	</body>
</html>