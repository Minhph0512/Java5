package com.example.ASMJAVA5.repository;

import com.example.ASMJAVA5.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsernameAndPassword(String username, String password);
}
