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
		
		String spage = request.getParameter("page");
		Long lpage = Long.parseLong(spage);
		Long page = (lpage-1)*5;
		List<BoardVo> list = new BoardDao().findAll(page);
		
		vo.setFirstViewCount(lpage);
		vo.setEndViewCount((vo.getFirstViewCount()-1)+5);
		if(totalcount % 5 > 0) {
			Long viewcount = totalcount/5 +1; 
			vo.setViewCount(viewcount);
		}else {
			Long viewcount = totalcount/5;
			vo.setViewCount(viewcount);
		}
		
		
		

		
		vo.setPage(lpage);
		request.setAttribute("page", vo);
		request.setAttribute("list", list);
		if(request.getParameter("next")!=null) {

			MvcUtil.forward("board/list", request, response);			
		}else if(request.getParameter("before") !=null){

			MvcUtil.forward("board/list", request, response);
		}
		else {	MvcUtil.forward("board/list", request, response);
		}
		
	}

}
