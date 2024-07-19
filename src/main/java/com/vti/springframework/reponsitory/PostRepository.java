package com.vti.springframework.reponsitory;

import com.vti.springframework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
