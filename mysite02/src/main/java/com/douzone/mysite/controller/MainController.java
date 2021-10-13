package com.douzone.mysite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.mvc.main.MainActionFactory;
import com.douzone.mysite.mvc.user.UserActionFactory;
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;
import com.douzone.web.util.MvcUtil;


//@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		String configPath = getServletConfig().getInitParameter("config");
		System.out.println("MainController.int() call : "+configPath);
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String actionName = request.getParameter("cmd");

		ActionFactory af = new MainActionFactory();
		Action action = af.getAction(actionName);
		action.execute(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
