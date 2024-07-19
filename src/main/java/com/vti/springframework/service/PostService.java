package com.vti.springframework.service;

import com.vti.springframework.entity.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    List<Post> findAll();

    Post findById(Long id);

    Post update (Long id,Post post);

    void deleteId (Long id);
}
