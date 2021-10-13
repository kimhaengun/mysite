package com.douzone.mysite.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.dao.UserDao;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String  sno = request.getParameter("no");
		Long no = Long.parseLong(sno);
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		HttpSession session = request.getSession(true);
		
		UserVo vo =null;
		if(password.equals("")) {
			vo = new UserVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setGender(gender);
			new UserDao().nopassowrdupdate(vo);
		}else {
			vo = new UserVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setPassword(password);
			vo.setGender(gender);
			new UserDao().update(vo);
		}
		session.setAttribute("authUser", vo);
		
		MvcUtil.redirect("/mysite02/user?cmd=updateform", request, response);

		
	}

}
