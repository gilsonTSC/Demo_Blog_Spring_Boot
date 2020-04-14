package com.gilson.demoblog.service;

import java.util.List;

import com.gilson.demoblog.model.Post;

public interface DemoblogService {

	List<Post> findAll();
	
	Post findById(Long id);
	
	Post save(Post post);
}