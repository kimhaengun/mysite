package com.douzone.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.service.GuestBookService;
import com.douzone.mysite.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping(value = {"","/"})
	public String list(Model model) {
		List<GuestBookVo> list = guestBookService.list();
		model.addAttribute("list",list);
		return "guestbook/list";
	}
	
	@RequestMapping(value = {"/spa"})
	public String spa(Model model) {

		return "guestbook/index-spa";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String write(GuestBookVo vo) {
		guestBookService.add(vo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value = "/delete/{no}")
	public String delete(@PathVariable("no")String no,Model model) {
		model.addAttribute("no",no);
		return "guestbook/delete";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(GuestBookVo vo) {
		guestBookService.delete(vo);
		return "redirect:/guestbook";
	}
}
