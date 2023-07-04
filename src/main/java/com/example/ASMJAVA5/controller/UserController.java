package com.example.ASMJAVA5.controller;

import com.example.ASMJAVA5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = { "/dashboard", ""})
    public String dashboard() {
        return "user/dashboard";
    }

    @GetMapping(value = "/index")
    public String abc(){
        return "redirect:/product/list";
    }
}
