package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface PostService {

    PostDto create(PostCreateForm form);

    Page<PostDto> findAll(Pageable pageable);

    PostDto findById(Long id);

    PostDto update (Long id, PostUpdateForm form);

    void deleteId (Long id);

}
