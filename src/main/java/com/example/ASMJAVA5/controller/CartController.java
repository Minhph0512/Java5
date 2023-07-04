package com.example.ASMJAVA5.controller;

import com.example.ASMJAVA5.service.Cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ICartService cart;

    @GetMapping()
    public String viewCart(Model model){
        model.addAttribute("cart", cart);

        return "cart";
    }
    @RequestMapping("/add/{id}")
    public String addtoOrder(@PathVariable("id") Integer id){
        cart.add(id);
        return "forward:/cart";
    }
    @RequestMapping("/themGioHang/{id}")
    public String addtoCart(@PathVariable("id") Integer id){
        cart.themGioHang(id);
        System.out.println();
        return "redirect:/product/list";
    }
}
