package com.gilson.demoblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gilson.demoblog.model.Post;
import com.gilson.demoblog.service.DemoblogService;

@Controller
public class DemoblogController {

	@Autowired
	private DemoblogService demoblogService;
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = this.demoblogService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = this.demoblogService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	@RequestMapping(value="/newpost", method=RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value="/newpost", method=RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		this.demoblogService.save(post);
		return "redirect:/posts";
	}
	
}