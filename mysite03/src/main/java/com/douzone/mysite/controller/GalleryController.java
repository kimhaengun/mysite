package com.douzone.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.mysite.service.GalleryService;
import com.douzone.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GalleryVo> list = galleryService.findAll();
		model.addAttribute("list", list);
		return "gallery/index";
	}
	
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String upload(
			@RequestParam(value = "comments",required = true,defaultValue = "")String comments,
			@RequestParam("file") MultipartFile file) {
		
		galleryService.saveImage(file, comments);
		return "redirect:/gallery";
	}
	
	//사진 삭제
	@RequestMapping(value = "/delete/{no}")
	public String delete(@PathVariable("no")Long no) {
		galleryService.removeImage(no);
		return "redirect:/gallery";
	}
}
