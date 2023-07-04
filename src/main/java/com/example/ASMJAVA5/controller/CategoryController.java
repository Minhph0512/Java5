package com.example.ASMJAVA5.controller;

import com.example.ASMJAVA5.entity.Category;
import com.example.ASMJAVA5.entity.Product;
import com.example.ASMJAVA5.repository.CategoryRepository;
import com.example.ASMJAVA5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/category/{id}/product")
    public String getAllProductById(Model model,
                                    @PathVariable Integer id
    ) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        List<Product> products = productRepository.findAllByCategoryId(id);
        model.addAttribute("products", products);

        return "category/detail";
    }
}
