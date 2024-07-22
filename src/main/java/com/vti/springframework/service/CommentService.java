package com.vti.springframework.service;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentUpdateForm;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();

    CommentDto create(Long postId,CommentCreateForm form);

    CommentDto findById(Long id);

    CommentDto update(Long id,CommentUpdateForm form);

    void deleteById(Long id);
}
