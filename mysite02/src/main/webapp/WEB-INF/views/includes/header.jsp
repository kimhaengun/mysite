<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<h1>MySite</h1>
	<ul>
		<li><a href="<%=request.getContextPath()%>/uer?cmd=loginform">로그인</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?cmd=joinform">회원가입</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?cmd=updateform">회원정보수정</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?cmd=logout">로그아웃</a>
		<li>
		<li>님 안녕하세요 ^^;</li>
	</ul>
</div>