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

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//로그인안한 유저가 접근하면 안됨.
		//접근 제한 걸기(Access Control) /보안, 인증체크
		HttpSession session = request.getSession();
	 	UserVo authuser = (UserVo) session.getAttribute("authUser");
		if(authuser == null) {
			MvcUtil.redirect(request.getContextPath(), request, response);
			return;
		}
		
		Long no = authuser.getNo();
		UserVo vo = new UserDao().findByNo(no);
		request.setAttribute("user", vo);
		
		MvcUtil.forward("user/updateform", request, response);
	}

}
