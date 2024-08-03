package com.vti.springframework.service;

import com.vti.springframework.dto.CommentDto;
import com.vti.springframework.form.CommentCreateForm;
import com.vti.springframework.form.CommentFilterForm;
import com.vti.springframework.form.CommentUpdateForm;
import com.vti.springframework.mapper.CommentMapper;
import com.vti.springframework.reponsitory.CommentReponsitory;
import com.vti.springframework.reponsitory.PostRepository;
import com.vti.springframework.specification.CommentSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentReponsitory commentReponsitory;
    private PostRepository postRepository;

    @Override
    public Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable) {
        var spec = CommentSpecification.buildSpec(form);
        return commentReponsitory.findAll(spec, pageable)
                .map(CommentMapper::map);

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
