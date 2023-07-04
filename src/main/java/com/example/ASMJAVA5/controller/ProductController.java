package com.example.ASMJAVA5.controller;


import com.example.ASMJAVA5.entity.Category;
import com.example.ASMJAVA5.entity.Product;
import com.example.ASMJAVA5.repository.CategoryRepository;
import com.example.ASMJAVA5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/list")
	public String productPage(Model model,
		@RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize,
		@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum
	) {
		
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		Page<Product> page = productRepository.findAll(pageable);
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		return "product/list";
	}
	
	@GetMapping("/detail/{id}")
	public String detailPage(Model model,
			@PathVariable(name = "id") Integer productId
		) {
		model.addAttribute("detail", productRepository.findById(productId).orElse(null));
		return "product/detail";
	}

}
