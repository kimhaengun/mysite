package com.douzone.mysite.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.mysite.service.UserService;
import com.douzone.mysite.vo.UserVo;

@RestController("userApiController")
@RequestMapping("/user/api")
public class UserController {
	@Autowired
	private UserService userService;
	
//	@ResponseBody
	@RequestMapping("/checkemail")
	public Map<String,Object> checkemail(
			@RequestParam(value = "email",required = true,defaultValue = "") String email) {
		System.out.println(email);
		UserVo userVo = userService.getUser(email);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("exist",userVo != null);
		return map;
	}
	
}
