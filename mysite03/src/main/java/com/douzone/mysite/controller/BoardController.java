package com.douzone.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.security.AuthUser;
import com.douzone.mysite.service.BoardService;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.PageVo;
import com.douzone.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/{no}")
	public String list(@PathVariable("no")Long pno,Model model) {
		PageVo vo = boardService.findcount(pno);
		
		
		List<BoardVo> list = boardService.findall(pno);
		model.addAttribute("page",vo);
		model.addAttribute("list",list);
		return "board/list";
	}
	@RequestMapping(value = "/{no}/e/{firstview}")
	public String list(@PathVariable("no")Long pno,@PathVariable("firstview") Long firstview, Model model) {
		PageVo vo = boardService.findcounts(pno,firstview);
		
		
		List<BoardVo> list = boardService.findall(pno);
		model.addAttribute("page",vo);
		model.addAttribute("list",list);
		return "board/list";
	}
	
	@Auth
	@RequestMapping(value = "/delete/{no}")
	public String delete(@AuthUser UserVo authUser, @PathVariable("no")Long no) {
			boardService.delete(no);	
		return "redirect:/board/1";
	}
	
	@RequestMapping(value = "/viewform/{no}")
	public String view(@PathVariable("no")Long no,Model model) {
		boardService.viewcount(no);
		BoardVo boardVo = boardService.view(no);
		model.addAttribute("vo",boardVo);
		return "board/view";
	}
	
	@RequestMapping(value = "/reply/{no}")
	public String reply(@PathVariable("no")Long no,Model model) {
		BoardVo vo = boardService.reply(no);
		model.addAttribute("vo", vo);
		return "board/reply";
	}
	@RequestMapping(value = "/reply",method = RequestMethod.POST)
	public String reply(BoardVo vo) {
		boardService.replyadd(vo);
		return "redirect:/board/1";
	}
	
	@RequestMapping(value = "/update/{no}")
	public String update(@PathVariable("no")Long no,Model model) {
		BoardVo boardVo = boardService.view(no);
		model.addAttribute("vo",boardVo);
		return "board/modify";
	}
	@RequestMapping(value = "/update")
	public String update(BoardVo boardVo,Model model) {
		boardService.update(boardVo);

		return "redirect:/board/1";
	}
	
	@Auth
	@RequestMapping(value= "/write")
	public String write() {
		
		return "board/write";
	}
	@RequestMapping(value= "/write",method = RequestMethod.POST)
	public String write(BoardVo vo) {
		boardService.write(vo);
		return "redirect:/board/1";
	}
}
