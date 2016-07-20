<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/WEB-INF/include/head.jsp" %>
	</head>
	<body>
		
		<p>main page</p>
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
		                                <a href="#this" name="title">${article.title }</a>
		                                <input type="hidden" id="IDX" value="${row.no }">
		                            </td>
		                            <td>${article.writer }</td>
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