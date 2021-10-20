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
						<td>${page.totalCount-status.index }
						<input type="hidden" name="userNo" value="${vo.userNo}"/>
						</td>
						<td style="text-align:left; padding-left: ${20*vo.depth}px">
						<c:if test="${vo.depth > 0 }">
							<img alt="" src="${pageContext.servletContext.contextPath }/assets/images/reply.png">
						</c:if>
						<a href="${pageContext.request.contextPath }/board/viewform/${vo.no}">${vo.title }</a></td>
						<td>${vo.userName }</td>
						<td>${vo.hit }</td>
						<td>${vo.regDate }</td>
						<td>
						<c:if test="${authUser.no eq vo.userNo }">
							<a href="${pageContext.request.contextPath }/board/delete/${vo.no}" class="dell">삭제</a>						
							<input type="hidden" name="tableNo" value="${vo.no }" />
						</c:if>
						</td>
					</tr>		
				</c:forEach>

				</table>
				
				<!-- pager 추가 / 연습 -->					
				<div class="pager">
					<ul>
					총 페이지수
					<c:forEach  var ="i" begin="1" end="${page.viewCount }">
						<li><a href="${pageContext.request.contextPath }/board?cmd=list&page=${i}">${i }</a></li>
					</c:forEach>
					<c:forEach var ="j" begin="${page.viewCount+1 }" end="5">
						<li>${j }</li>
					</c:forEach>
					</ul>
				</div>

				<!-- pager 추가 / 이게 메인-->					
				<div class="pager">
					<ul>
					<!-- 이전 버튼 -->
					<c:if test="${page.firstViewCount > 1 }">
						<a href="${pageContext.request.contextPath }/board/${page.page}/e/${page.firstViewCount-1}">이전</a>
					</c:if>
					
					<!-- 페이지 수 -->					
					<c:forEach  var ="i" begin="${page.firstViewCount }" end="${page.endViewCount }">
						<c:choose>
						
							<c:when test="${page.viewCount >= i }">
								<li><a href="${pageContext.request.contextPath }/board/${i}">${i }</a></li>
							</c:when>
							
							<c:otherwise>
							<c:if test="${page.viewCount < i }">
									<li>${i }</li>
							</c:if>
							</c:otherwise>
							
						</c:choose>
					</c:forEach>
					
					<!-- 다음 버튼 -->
					<c:if test="${page.firstViewCount < page.viewCount }">
						<a href="${pageContext.request.contextPath }/board/${page.page}/e/${page.firstViewCount+1 }">다음</a>
					</c:if>
					</ul>
				</div>
								
				<c:if test="${not empty authUser }">
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board/write" id="new-book">글쓰기</a>
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