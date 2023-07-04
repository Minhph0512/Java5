package com.example.ASMJAVA5.repository;


import com.example.ASMJAVA5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("SELECT p FROM Product p WHERE p.category.id = :cate")
    public List<Product> findAllByCategoryId(@Param("cate") Integer categoryId);
}
