package com.douzone.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class BoardreplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String suserno = request.getParameter("userno");
		Long userno = Long.parseLong(suserno);
		
		String sgroupno = request.getParameter("groupno");
		Long groupno = Long.parseLong(sgroupno);
		
		String sorderno = request.getParameter("orderno");
		Long orderno = Long.parseLong(sorderno);
		
		String sdepth = request.getParameter("depth");
		Long depth = Long.parseLong(sdepth);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		BoardVo vo2 = new BoardVo();
		vo2.setTitle(title);
		vo2.setContent(content);
		vo2.setGroupNo(groupno);
		vo2.setOrderNo(orderno);
		vo2.setDepth(depth);
		vo2.setUserNo(userno);
		new BoardDao().replyInsert(vo2);
		
		
		BoardVo vo1 = new BoardVo();
		vo1.setGroupNo(groupno);
		vo1.setOrderNo(orderno);
		new BoardDao().replyUpdate(vo1);
		
		MvcUtil.redirect("/mysite02/board?cmd=list", request, response);
		
	}

}
