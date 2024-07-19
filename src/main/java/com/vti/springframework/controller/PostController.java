package com.vti.springframework.controller;

import com.vti.springframework.entity.Post;
import com.vti.springframework.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("api/v1/posts")
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping("/api/v1/posts")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("api/v1/posts/{id}")
    public Post findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PutMapping("api/v1/posts/{id}")
    public Post update(@PathVariable("id") Long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        postService.deleteId(id);

    }

}
