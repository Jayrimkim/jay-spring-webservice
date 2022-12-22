package com.jay.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    /*OAuth*/
    Optional<User> findByEmail(String email);

    /*user 조회*/
    Optional<User> findById(Long id);
}
