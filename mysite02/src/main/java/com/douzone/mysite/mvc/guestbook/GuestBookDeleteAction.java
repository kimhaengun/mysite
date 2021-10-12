package com.douzone.mysite.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.GuestBookDao;
import com.douzone.mysite.vo.GuestBookVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class GuestBookDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GuestBookVo vo = new GuestBookVo();
		String sno = request.getParameter("no");
		Long no = Long.parseLong(sno);
		String password = request.getParameter("password");
		vo.setNo(no);
		vo.setPassword(password);
		
		GuestBookDao dao = new GuestBookDao();
		dao.delete(vo);
		
		MvcUtil.redirect("/mysite02/gb?cmd=list", request, response);
	}

}
