<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
					<input type="hidden" name="userno" value="${authUser.no}"/>
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th style="text-align:left">제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
				<c:set var="count" value="${fn:length(list) }" />
				<c:forEach items="${list }" var="vo" varStatus="status">
					<tr>
						<td>${count-status.index }
						<input type="hidden" value="${vo.userNo}"/>
						</td>
						<td style="text-align:left; padding-left: ${20*vo.depth}px">
						<c:if test="${vo.depth > 0 }">
							<img alt="" src="${pageContext.servletContext.contextPath }/assets/images/reply.png">
						</c:if>
						<a href="${pageContext.request.contextPath }/board?cmd=viewform&no=${vo.no}">${vo.title }</a></td>
						<td>${vo.userName }</td>
						<td>${vo.hit }</td>
						<td>${vo.regDate }</td>
						<td>
						<c:if test="${authUser.no eq vo.userNo }">
							<a href="${pageContext.request.contextPath }/board?cmd=delete&no=${vo.no}" class="dell">삭제</a>						
						</c:if>
						</td>
					</tr>		
				</c:forEach>

				</table>
				
				<!-- pager 추가 -->
				
				
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="">${page.viewCount}</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				
				
					
				<div class="pager">
					<ul>
					<c:forEach  var ="i" begin="1" end="${page.viewCount }">
						<li><a href="pageContext.request.contextPath }/board?cmd=delete&no=${i}">${i }</a></li>
					</c:forEach>
					<c:forEach var ="j" begin="${page.viewCount+1 }" end="5">
						<li>${j }</li>
					</c:forEach>
					</ul>
				</div>

									
				<!-- pager 추가 -->
				
				<c:if test="${not empty authUser }">
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board?cmd=writeform" id="new-book">글쓰기</a>
				</div>
				</c:if>				
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>