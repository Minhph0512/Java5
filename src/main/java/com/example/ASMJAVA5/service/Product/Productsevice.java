package com.example.ASMJAVA5.service.Product;

import com.example.ASMJAVA5.entity.Product;
import com.example.ASMJAVA5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Productsevice implements IProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        Page<Product> list = productRepository.findAll(pageable);
        return list;
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deletebyId(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }
}
