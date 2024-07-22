package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostUpdateForm;

import java.util.List;

public interface PostService {

    PostDto create(PostCreateForm form);

    List<PostDto> findAll();

    PostDto findById(Long id);

    PostDto update (Long id, PostUpdateForm form);

    void deleteId (Long id);

}
