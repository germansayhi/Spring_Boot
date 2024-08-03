package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostFilterForm;
import com.vti.springframework.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PostService {

    PostDto create(PostCreateForm form);

    Page<PostDto> findAll(PostFilterForm form, Pageable pageable);

    Page<PostDto> findByTitleContaining(String search, Pageable pageable);

    List<PostDto> findByIdBetween(Long minId, Long maxId);

    List<PostDto> findByTitle(String title);

    PostDto findById(Long id);

    PostDto update (Long id, PostUpdateForm form);

    void updateTilte(Long id, String title);

    void deleteId (Long id);

    void deleteByTitle(String title);
}
