package com.douzone.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.service.SiteService;
import com.douzone.mysite.vo.SiteVo;

@Auth(role="ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private SiteService siteService;
	
	@RequestMapping("")
	public String main(Model model) {
		SiteVo siteVo = siteService.sitefind();
		model.addAttribute("siteVo",siteVo);
		return "admin/main";
	}

	@RequestMapping("/main/update")
	public String update(SiteVo siteVo,@RequestParam("file") MultipartFile file, Model model) {
			siteService.siteUpdate(siteVo,file);
		return "redirect:/admin";
	}
	
	
	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "admin/main";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/main";
	}
}
