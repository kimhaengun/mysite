package com.douzone.mysite.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.GuestBookDao;
import com.douzone.mysite.vo.GuestBookVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class GuestBookWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String content = request.getParameter("content");
		
		GuestBookVo guestbookvo = new GuestBookVo();
		guestbookvo.setName(name);
		guestbookvo.setPassword(password);
		guestbookvo.setMessage(content);
		
		new GuestBookDao().insert(guestbookvo);
		
		MvcUtil.redirect("/mysite02/gb?cmd=list", request, response);
	}

}
