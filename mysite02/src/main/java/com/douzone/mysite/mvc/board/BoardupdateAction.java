package com.douzone.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class BoardupdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stableno = request.getParameter("no");
		Long tableno = Long.parseLong(stableno);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setNo(tableno);
		vo.setTitle(title);
		vo.setContent(content);
		new BoardDao().update(vo);
		
		request.setAttribute("vo", vo);
		
		MvcUtil.forward("board/view", request, response);
	}

}
