<%@page import="com.douzone.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserVo authUser = (UserVo)session.getAttribute("authUser");
%>	

<div id="header">
	<h1>MySite</h1>
	<ul>	
		<%
			if(null==authUser){
		%>
		<li><a href="<%=request.getContextPath()%>/user?cmd=loginform">로그인</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?cmd=joinform">회원가입</a>
		<li>
		<%
			}else{
		%>
		<li><a href="<%=request.getContextPath()%>/user?cmd=updateform">회원정보수정</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?cmd=logout">로그아웃</a>
		<li>
		<li><%=authUser.getName() %>님 안녕하세요 ^^;</li>
		<%
			}
		%>
	</ul>
</div>