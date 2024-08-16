package com.vti.springframework.reponsitory;

import com.vti.springframework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {
    User findByUsernameOrEmail(String username, String email);
}
