package com.douzone.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.mvc.user.UserActionFactory;
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

//@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String actionName = request.getParameter("cmd");

		ActionFactory af = new UserActionFactory();
		Action action = af.getAction(actionName);
		action.execute(request,response);

//		if("joinform".equals(action)) {
//			MvcUtil.forward("WEB-INF/views/user/joinform.jsp", request, response);		
//		}else if("join".equals(action)) {
//			
//		}else {
//			//장난친놈 - 비정상 주소
//			MvcUtil.redirect("/mysite02",request,response);
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
