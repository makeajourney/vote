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
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="exampleModalLabel"></h4>
								</div>
								<div class="modal-body" id="popup">
									<form>
										<div class="form-group">
											<input type="text" class="form-control" id="recipient-name" />
										</div>											
									</form>
									<button type="button" class="btn btn-primary pull-right">Copy to clipboard</button>
								</div>
							</div>
						</div>
					</div>
					<div class="cbtn3">
						<button class="outerbtn linkbtn" id="linkBtn" type="button" data-toggle="modal" data-target="#exampleModal">link</button>
						<c:if test="${article.userNo eq user.no}">
							<button class="outerbtn deletebtn" onclick='location.href="<c:url value='/deleteVote.do?articleno=${article.no }' />"'>delete</button>
							<button class="outerbtn upbtn">update</button>
						</c:if>
					</div>
				</div>
			</div>
			<div class="main">
				<div class="page-header">
				<div id="title">
					${article.title }
					<div class="name">${article.userName}
						<div class="date">
							${article.updateTime }
						</div>
					</div>
				</div>
				</div>
				<div class="img">
				
					<c:if test="${fn:length(votefiles) > 0}">
						<c:forEach items="${votefiles }" var="votefile">
							<img class="img" src="<c:url value='/common/getImageFile.do?fileno=${votefile.no }' />" />
						</c:forEach>
					</c:if>
					
				</div>
				<p class="lead">
					${article.content }
				</p>
				<div class="tags">
					<p>
						<c:choose>
							<c:when test="${fn:length(tags)>0 }">
								<c:forEach items="${tags }" var="tagValue">
									<a>#${tagValue.tag }</a>
								</c:forEach>
							</c:when>
							<c:otherwise>
								입력된 태그가 없습니다.
							</c:otherwise>
						</c:choose>
					</p>
				</div>

				<div class="vote">
					<c:choose>
						<c:when test="${fn:length(voteElements) > 0}">
							<c:forEach items="${voteElements }" var="voteElement">
							
								<div class="item">
									
									<div id="item1" class="div_item">
										<div class="itemname">
											${voteElement.content }
										</div>
									</div>
									<div class="itemnum">3<br>
									</div>
								</div>
							
							</c:forEach>
							
							<!-- 투표버튼 -->
							<div>
								<input type="button" class="votebtn" value="VOTE" />
							</div>
						</c:when>
						<c:otherwise>
							<p>입력된 투표항목이 없습니다.</p>
						</c:otherwise>
					</c:choose>
				</div>
				
			</div>
			<div class="comment">
				<form id="commentform" action="addComment.do" method="post" onsubmit="return chkformComment();">
					<input type="hidden" name="articleno" value="${article.no }" />
					<input type="checkbox" class="checked" id="checked" onchange="changeAction();" /> suggest the vote element
					<input type="text" name="voteSuggest" id="sgbox" class="sgbox" placeholder=" vote element"/><br>
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
							<div class="username">${comment.userName}
								<div class="date">${comment.updateDate }
								</div>
							</div>
							<div>
								<form action="updateComment.do" method="post">
									<input type="hidden" name="commentno" value="${comment.no }" />
									<p>${comment.context }</p>
									
									<c:if test="${comment.suggestElementNo != ''}">
										<div>
											Suggest the vote element
											<span class="sgitem">${comment.suggestElementContext }</span>
											<input type="button" class="likebtn" value="like" onclick='location.href="<c:url value='/updateLikeCount.do?articleno=${article.no }&elementno=${comment.suggestElementNo }' />"'/>
											<span>6</span>
										</div>
									</c:if>
							
									
								</form>
								<c:if test="${comment.userNo eq user.no}">
		
									
									<div class="cbtn3">
										<button class="cbtn2 edit" onclick="editcomment(this)">edit</button>
										<button class="cbtn2 delete" onclick='location.href="<c:url value='/deleteComment.do?articleno=${article.no }&commentno=${comment.no }' />"'>
											delete
										</button>
									</div>
								</c:if>
							</div>
							
							
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p>입력된 댓글이 없습니다.</p>
				</c:otherwise>
			</c:choose>
		
		<div class="bottombtn">
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
