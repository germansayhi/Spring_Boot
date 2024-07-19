package com.vti.springframework.service;

import com.vti.springframework.entity.Post;
import com.vti.springframework.reponsitory.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return
        postRepository.findById(id)
                .orElseThrow();


    }

    @Override
    public Post update(Long id,Post post) {
        var optional =postRepository.findById(id);
        if(optional.isEmpty())
        return null;
        var old = optional.get();
        old.setTitle(post.getTitle());
        old.setContent(post.getContent());
        old.setContent(post.getDescription());
        return postRepository.save(old);
    }

    @Override
    public void deleteId(Long id) {
        postRepository.deleteById(id);

    }
}
