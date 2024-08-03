package com.vti.springframework.reponsitory;

import com.vti.springframework.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentReponsitory extends
        JpaRepository<Comment, Long>,
        JpaSpecificationExecutor<Comment> {

}