package com.ayrotek.productservice.repository;

import com.ayrotek.productservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByToken(String token);
}
