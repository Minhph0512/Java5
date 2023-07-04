package com.example.ASMJAVA5.controller;

import com.example.ASMJAVA5.entity.Category;
import com.example.ASMJAVA5.entity.Product;
import com.example.ASMJAVA5.entity.Users;
import com.example.ASMJAVA5.repository.CategoryRepository;
import com.example.ASMJAVA5.repository.ProductRepository;
import com.example.ASMJAVA5.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CRUDController {
    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private CategoryRepository  categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    //USER
    @GetMapping("/CRUD/users")
    public String getFormUsers(Model model) {

        model.addAttribute("user",usersRepository.findAll());

        return "CRUD/users";
    }
    @GetMapping("/CRUD/users/detail/{id}")
    public String getFormUsersedit(Model model,
                                   @PathVariable(name="id")Integer id) {



        model.addAttribute("user",usersRepository.findById(id).orElse(null));
        return "CRUD/userUpdate";
    }

    @PostMapping("/CRUD/users/create")
    public String createUsers(Model model,
                         @Valid @ModelAttribute("user") Users user){
    usersRepository.save(user);

        return "redirect:/CRUD/users";
    }
    @PostMapping("/CRUD/users/update/{id}")
    public String updateUser(Model model,
                             @PathVariable(name="id")Integer id,
                             @Valid @ModelAttribute("user") Users user){
        Users u = usersRepository.findById(id).orElse(null);
        user.setId(u.getId());
        BeanUtils.copyProperties(user,u);
        usersRepository.save(u);

        return "redirect:/CRUD/users";

    }
    @RequestMapping("/CRUD/users/delete/{id}")
    public String deleteUsers(Model model,
                         @PathVariable(name="id")Integer id){
        usersRepository.deleteById(id);

    return "redirect:/CRUD/users";
    }

    //Category
    @GetMapping("/CRUD/category")
    public String getFormCategory(Model model) {

        model.addAttribute("categories",categoryRepository.findAll());

        return "CRUD/category";
    }
    @PostMapping("/CRUD/category/create")
    public String createCategory(Model model,
                              @Valid @ModelAttribute("category") Category category){
        categoryRepository.save(category);

        return "redirect:/CRUD/category";
    }
    @RequestMapping("/CRUD/category/delete/{id}")
    public String deleteCategory(Model model,
                              @PathVariable(name="id")Integer id){
        categoryRepository.deleteById(id);

        return "redirect:/CRUD/category";
    }

    //Product
    @GetMapping("/CRUD/product")
    public String getFormProduct(Model model) {

        model.addAttribute("categories",categoryRepository.findAll());
        model.addAttribute("products",productRepository.findAll());

        return "CRUD/product";
    }
    @PostMapping("/CRUD/product/create")
    public String createProduct(Model model,
                                @Valid @ModelAttribute("product")Product product){
        productRepository.save(product);

        return "redirect:/CRUD/product";
    }
    @RequestMapping("/CRUD/product/delete/{id}")
    public String deleteProduct(Model model,
                                 @PathVariable(name="id")Integer id){
        productRepository.deleteById(id);

        return "redirect:/CRUD/product";
    }
    @GetMapping("/CRUD/product/detail/{id}")
    public String getFormProductdetail(Model model,
                                   @PathVariable(name="id")Integer id) {
        model.addAttribute("product",productRepository.findById(id).orElse(null));
        model.addAttribute("categories",categoryRepository.findAll());
        return "CRUD/productdetail";
    }
    @PostMapping("/CRUD/product/update/{id}")
    public String updateProcuct(Model model,
                             @PathVariable(name="id")Integer id,
                             @Valid @ModelAttribute("product") Product product){
        Product product1 = productRepository.findById(id).orElse(null);
       product.setId(product1.getId());
        BeanUtils.copyProperties(product,product1);
        productRepository.save(product1);

        return "redirect:/CRUD/product";

    }
    @GetMapping("/dangki")
    public String getfromdk(){
        return "/dangki";
    }
    @PostMapping("/dangki/create")
    public String createdk(Model model,
                              @Valid @ModelAttribute("user") Users user){
        usersRepository.save(user);

        return "redirect:/login";
    }
}
