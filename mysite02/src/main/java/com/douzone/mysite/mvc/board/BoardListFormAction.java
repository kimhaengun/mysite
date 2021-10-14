package com.douzone.mysite.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.PageVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class BoardListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PageVo vo = new BoardDao().findcount();
		Long totalcount = vo.getTotalCount();
		if(totalcount % 5 > 0) {
			Long viewcount = totalcount/5 +1; 
			vo.setViewCount(viewcount);
		}else {
			Long viewcount = totalcount/5;
			vo.setViewCount(viewcount);
		}
		
		request.setAttribute("page", vo);
		
		
		List<BoardVo> list = new BoardDao().findAll();

		request.setAttribute("list", list);
		
		MvcUtil.forward("board/list", request, response);
	}

}
