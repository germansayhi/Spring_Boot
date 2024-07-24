package com.vti.springframework.controller;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentUpdateForm;
import com.vti.springframework.service.CommentService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("api/v1/comments")
    public Page<CommentDto> findAll(Pageable pageable) {
        return commentService.findAll(pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public CommentDto create(
            @PathVariable("postId") Long postId,
            @RequestBody CommentCreateForm form
    ) {
        return commentService.create(postId, form);
    }

    @GetMapping("api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @PutMapping("api/v1/comments/{id}")
    public CommentDto update(@PathVariable("id") Long id, @RequestBody CommentUpdateForm form) {
        return commentService.update(id, form);
    }

    @DeleteMapping("api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        commentService.deleteById(id);

    }
}
