package com.vti.springframework.controller;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentFilterForm;
import com.vti.springframework.form.CommentUpdateForm;
import com.vti.springframework.service.CommentService;
import com.vti.springframework.validation.CommentIdExists;
import com.vti.springframework.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("api/v1/comments")
    public Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable) {
        return commentService.findAll(form, pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(
            @PathVariable("postId") @PostIdExists Long postId,
            @RequestBody @Valid CommentCreateForm form
    ) {
        return commentService.create(postId, form);
    }

    @GetMapping("api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") @CommentIdExists Long id) {
        return commentService.findById(id);
    }

    @PutMapping("api/v1/comments/{id}")
    public CommentDto update(@PathVariable("id") Long id, @RequestBody @Valid CommentUpdateForm form) {
        return commentService.update(id, form);
    }

    @DeleteMapping("api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") @CommentIdExists Long id) {
        commentService.deleteById(id);

    }
}
