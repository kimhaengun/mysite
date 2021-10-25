package com.douzone.mysite.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.mysite.security.Auth;

@Controller
public class MainController {
	
	@RequestMapping({"","/"})
	public String index() {
		return "main/index";
	}
	
	@RequestMapping("/hello")
	public void message(HttpServletResponse response) throws Exception{
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print("{\"message\":\"Hello world\"}");
		
	}
}
