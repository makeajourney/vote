<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
		<link href="css/main.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="/WEB-INF/include/header.jsp" %>
		
		<div class=container>
			<table class="table">
				<thead>
					<tr>
						<td>NO</td>
						<td>TITLE</td>
						<td>WRITER</td>
						<td>DATETIME</td>
						<td>HIT COUNT</td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
		                <c:when test="${fn:length(articleList) > 0}">
		                    <c:forEach items="${articleList }" var="article">
		                        <tr>
		                            <td>${article.no}</td>
		                            <td class="title">
		                                <a href="<c:url value='/voteDetail.do?articleno=${article.no }' />">
		                                	${article.title }
		                                </a>
		                            </td>
		                            <td>${article.userName }</td>
		                            <td>${article.createTime }</td>
		                            <td>${article.hitCount }</td>
		                        </tr>
		                    </c:forEach>
		                </c:when>
		                <c:otherwise>
		                    <tr>
		                        <td colspan="5">조회된 결과가 없습니다.</td>
		                    </tr>
		                </c:otherwise>
		            </c:choose>
				</tbody>
			</table>
		</div>
		
		<%@ include file="/WEB-INF/include/footer.jsp" %>
	</body>
</html>