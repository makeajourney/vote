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
			<div class="outer">
				<div>
					<button class="listbtn" onclick='location.href="<c:url value='/main.do' />"'> &lt; list</button>
					<div class="cbtn3">
						<button class="outerbtn linkbtn">link</button>
						<c:if test="${article.userNo eq user.no}">
							<button class="outerbtn deletebtn" onclick='location.href="<c:url value='/deleteVote.do?articleno=${article.no }' />"'>delete</button>
							<button class="outerbtn upbtn">update</button>
						</c:if>
					</div>
				</div>
			</div>
			<div class="main">
				<div class="page-header">
					<h2>${article.title }</h2>
					<div class="date">
						${article.updateTime }
						<div class="name">${article.userName}</div>
					</div>
				</div>
				<div class="img">
					<img src="http://imgnews.naver.net/image/215/2015/08/21/A201508210041_1_99_20150821103503.jpg?type=w540"/>
				</div>
				<p class="lead">
					${article.content }
				</p>
				<div class="tags">
					<p><a>#expensive</a> <a>#car</a> <a>#please</a> <a>#choose</a> <a>#one</a></p>
				</div>
				
				<!-- 투표항목 조회 테스트용 코드 -->
				<p>vote element test</p>
				
				
				<c:choose>
					<c:when test="${fn:length(voteElements) > 0}">
						<c:forEach items="${voteElements }" var="voteElement">
							<p>${voteElement.content }</p>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>입력된 댓글이 없습니다.</p>
					</c:otherwise>
				</c:choose>
				<!-- 투표항목 조회 테스트용 코드 끝 -->
				
				
				<div class="vote">
					<div class="item">
						<div class="item1">
							<div class="label">
								BMW
								<span class="tooltiptext">1.53%</span>
							</div>
						</div>
						<div class="itemnum">3<br></div>
					</div>
					<div class="item">
						<div class="item2">
							<div class="label">Mercedes-Benz</div>
						</div>
						<div class="itemnum">37<br></div>
					</div>
					<div class="item">
						<div class="item3">
							<div class="label">LAND ROVER</div>
						</div>
						<div class="itemnum">127<br></div>
					</div>
					<div class="item">
						<div class="item4">
							<div class="label">BENTLY</div>
						</div>
						<div class="itemnum">28</div>
					</div>
					<div>
						<input type="button" class="votebtn" value="VOTE!!" />
					</div>
				</div>
			</div>
			<div class="comment">
				<form class="commentform" action="addComment.do" method="post" onsubmit="return chkformComment();">
					<input type="hidden" name="articleno" value="${article.no }" />
					<input type="checkbox" class="checked" id="checked" /> suggest the vote element
					<input type="text" id="sgbox" class="sgbox" placeholder=" vote element"/><br>
					<div class="box">
						<input type="text" name="context" id="cbox" class="cbox"/>
						<button type="submit" class="cbtn">Submit</button>
					</div>
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
								<div>
									<input type="text" class="edittext"/>
								</div>
							</div>

							<c:if test="${comment.userNo eq user.no}">

								<div class="cbtn3">
									<button class="cbtn2 edit">edit</button>
									<button class="cbtn2 delete" onclick='location.href="<c:url value='/deleteComment.do?articleno=${article.no }&commentno=${comment.no }' />"'>
										delete
									</button>
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
				<div>
					<p>I want to buy Chrysler.</p>
				</div>
				<div>
					Suggest the vote element
					<span class="sgitem">Chrysler</span>
				</div>
				<div class="cbtn3">
					<button class="cbtn2 edit">edit</button>
					<button class="cbtn2 delete">delete</button>
				</div>
			</div>
		</div>
		<div>
			<button class="listbtn" onclick='location.href="<c:url value='/main.do' />"'> &lt; list</button>
			<div class="topbtn">
				<a href="#">top</a>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/include/footer.jsp" %>
	<script src="js/votecontents.js"></script>
</body>
</html>
