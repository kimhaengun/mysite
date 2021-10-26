package com.douzone.mysite.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.security.AuthUser;
import com.douzone.mysite.service.UserService;
import com.douzone.mysite.vo.UserVo;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

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
	public String join(@ModelAttribute @Valid UserVo vo,BindingResult result,Model model) {
		if(result.hasErrors()) { //에러가 있으면~
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				System.out.println(error);
			}
//			Map<String , Object> map = result.getModel();
//			model.addAttribute("userVo", map.get("userVo"));
			
			//위와 같은 코드 simple~
			model.addAllAttributes(result.getModel());
			
			return "user/join";
		}
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
	
	@Auth
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(@AuthUser UserVo authUser,UserVo userVo) {
		
		userVo.setNo(authUser.getNo());
		userService.updateUser(userVo);
		
		//세션 정보 변경
		authUser.setName(userVo.getName());
		return "redirect:/user/update";
	}	
	
}
