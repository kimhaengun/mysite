package com.douzone.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.service.UserService;
import com.douzone.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(UserVo vo) {
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping(value = "/joinsuccess",method = RequestMethod.GET)
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@Auth
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String update(@AuthUser UserVo authUser,Model model) {
		Long no = authUser.getNo();
		UserVo userVo = userService.getUser(no);
		
		model.addAttribute("user",userVo);
		return "user/update";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(HttpSession session,UserVo userVo) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		//주소 접근 제어 (Access Control List)
		if(authUser == null) {
			return "redirect:/";
		}
		userVo.setNo(authUser.getNo());
		userService.updateUser(userVo);
		
		//세션 정보 변경
		authUser.setName(userVo.getName());
		return "redirect:/user/update";
	}	
}
