package com.vti.springframework.reponsitory;

import com.vti.springframework.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    // 1.Method name
    // Tiền tố: findBy, countBy, existsBy, deleteBy

    // VD: Lấy ra tat cả post theo title
    // Where title =?
    List<Post> findByTitle(String title);

    // VD: lấy ra tat cả post có minId<=id <= maxId
    // WHERE id between ? AND ?

    List<Post> findByIdBetween(Long minId, Long maxId);

    // VD: Tìm kiếm post theo title
    Page<Post> findByTitleContaining(String search, Pageable pageable);

    // VD: xóa post theo title
    void deleteByTitle(String title);

    // Kiem tra title co ton tai khong
    Boolean existsByTitle(String title);

    // 2. @Query annotation

    // VD: Cập nhật title cho post
    @Query("UPDATE Post SET title = :title WHERE id = :id")
    @Modifying
    void updateTitle(@Param("id") Long id,@Param("title") String title);

    // VD: Cập nhật title cho post
//    @Query("UPDATE Post SET title = ?2 WHERE id = ?1")
//    @Modifying
//    void updateTitle( Long id, String title);

//    @Query(value = "UPDATE Post SET title = :title WHERE id = :id", nativeQuery = true)
    // @Modifying
//    void updateTitle(@Param("id") Long id,@Param("title") String title);

}
