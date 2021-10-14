package com.douzone.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class BoardreplyformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stableno = request.getParameter("no");
		Long tableno = Long.parseLong(stableno);
		
		BoardVo vo = new BoardDao().findByTableNo(tableno);
		request.setAttribute("vo", vo);
		

		MvcUtil.forward("/board/reply", request, response);
	}

}
