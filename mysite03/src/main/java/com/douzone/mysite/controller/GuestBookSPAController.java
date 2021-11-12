package com.douzone.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.mysite.dto.JsonResult;
import com.douzone.mysite.service.GuestBookService;
import com.douzone.mysite.vo.GuestBookVo;

@Controller
@RequestMapping("/api/gb")
public class GuestBookSPAController {
	@Autowired
	private GuestBookService guestBookService;
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonResult add(@RequestBody GuestBookVo vo) {
		System.out.println("ajax 통신 완료");
		System.out.println("ajax 받아온 값 : "+vo.toString());
		
		GuestBookVo guestBookVo = guestBookService.add(vo);
		System.out.println("================"+guestBookVo);
		return JsonResult.success(guestBookVo);
	}
}
