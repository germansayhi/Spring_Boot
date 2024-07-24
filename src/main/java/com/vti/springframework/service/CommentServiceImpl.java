package com.vti.springframework.service;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentUpdateForm;
import com.vti.springframework.mapper.CommentMapper;
import com.vti.springframework.mapper.PostMapper;
import com.vti.springframework.reponsitory.CommentReponsitory;
import com.vti.springframework.reponsitory.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentReponsitory commentReponsitory;
    private PostRepository postRepository;

    @Override
    public List<CommentDto> findAll() {
        return commentReponsitory.findAll()
                .stream()
                .map(CommentMapper::map)
                .toList();
    }

    @Override
    public CommentDto create(Long postId, CommentCreateForm form) {
        var optional = postRepository.findById(postId);
        if(optional.isEmpty()){
            return null;
        }
        var post = optional.get();
        var comment = CommentMapper.map(form);
        comment.setPost(post);
        var saveComment = commentReponsitory.save(comment);
        return CommentMapper.map(saveComment);
    }

    @Override
    public CommentDto findById(Long id) {
        return
                commentReponsitory.findById(id)
                        .map(CommentMapper::map)
                        .orElse(null);
    }

    @Override
    public CommentDto update(Long id, CommentUpdateForm form) {
        var optional = commentReponsitory.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        var comment = optional.get();
        CommentMapper.map(form,comment);
        var saveComment = commentReponsitory.save(comment);
        return CommentMapper.map(saveComment);
    }

    @Override
    public void deleteById(Long id) {
        commentReponsitory.deleteById(id);

    }
}