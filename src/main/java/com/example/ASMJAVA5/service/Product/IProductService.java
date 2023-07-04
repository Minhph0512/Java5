package com.example.ASMJAVA5.service.Product;

import com.example.ASMJAVA5.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);

    void add(Product product);

    void deletebyId(int id);

    Product getById(int id);

    void update (Product product);
}
