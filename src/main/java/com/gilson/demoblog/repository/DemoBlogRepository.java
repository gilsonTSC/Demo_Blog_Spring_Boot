package com.gilson.demoblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilson.demoblog.model.Post;

public interface DemoBlogRepository extends JpaRepository<Post, Long>{

}