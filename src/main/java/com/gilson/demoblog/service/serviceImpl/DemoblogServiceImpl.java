package com.gilson.demoblog.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilson.demoblog.model.Post;
import com.gilson.demoblog.repository.DemoBlogRepository;
import com.gilson.demoblog.service.DemoblogService;

@Service
public class DemoblogServiceImpl implements DemoblogService{

	@Autowired
	private DemoBlogRepository repo;
	
	@Override
	public List<Post> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Post findById(Long id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return this.repo.save(post);
	}

}