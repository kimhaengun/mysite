package com.douzone.mysite.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.mysite.security.Auth;

@Controller
public class MainController {
	
	@RequestMapping({"","/"})
	public String index() {
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping("/msg01")
	public String message01() {
		return "안녕";
	}
	
	@ResponseBody
	@RequestMapping("/msg02")
	public Object message02(/* HttpServletResponse response */) throws Exception{
//		response.setContentType("application/json; charset=UTF-8");
//		response.getWriter().print("{\"message\":\"Hello world\"}");
//		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Hello");
		
		return map;
	}
}
