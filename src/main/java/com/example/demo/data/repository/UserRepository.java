package com.example.demo.data.repository;

import com.example.demo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ksatish on 01-02-2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
