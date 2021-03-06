package com.douzone.mysite.mvc.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.dao.UserDao;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo uservo = new UserDao().findByEmailAndPassword(email, password);
		if(uservo == null) {
			//로그인 실패
			request.setAttribute("result", "fail");
			MvcUtil.forward("user/loginform", request, response);
			return;
		}
		System.out.println("인증처리 / 세션처리 해야함");
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", uservo);
		
		MvcUtil.redirect("/mysite02", request, response);
	}

}
