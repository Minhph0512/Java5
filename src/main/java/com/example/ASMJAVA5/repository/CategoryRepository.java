package com.example.ASMJAVA5.repository;

import com.example.ASMJAVA5.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
