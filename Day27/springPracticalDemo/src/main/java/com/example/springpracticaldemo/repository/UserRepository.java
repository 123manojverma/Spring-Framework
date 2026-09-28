package com.example.springpracticaldemo.repository;

import com.example.springpracticaldemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByUsername(String username);
}
