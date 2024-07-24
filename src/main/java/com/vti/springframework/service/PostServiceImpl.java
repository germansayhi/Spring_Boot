package com.vti.springframework.service;

import com.vti.springframework.dto.PostDto;
import com.vti.springframework.entity.Post;
import com.vti.springframework.form.PostCreateForm;
import com.vti.springframework.form.PostUpdateForm;
import com.vti.springframework.mapper.PostMapper;
import com.vti.springframework.reponsitory.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;


    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);
    }

    @Override
    public Page<PostDto> findAll(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(PostMapper::map);

    }

    @Override
    public PostDto findById(Long id) {
        return
        postRepository.findById(id)
                .map(PostMapper::map)
                .orElse(null);


    }

    @Override
    public PostDto update(Long id, PostUpdateForm form) {
        var optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var post = optional.get();
        PostMapper.map(form, post);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);

    }

    @Override
    public void deleteId(Long id) {
        postRepository.deleteById(id);

    }
}
