package com.gilson.demoblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gilson.demoblog.model.Post;
import com.gilson.demoblog.service.DemoblogService;

@Controller
public class DemoblogController {

	@Autowired
	private DemoblogService demoblogService;
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public ModelAndView getPots() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = this.demoblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
}