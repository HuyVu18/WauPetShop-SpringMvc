package com.example.waupetshop.controller;

import com.example.waupetshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin("*")
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    @GetMapping
    public ModelAndView viewCart() {
        ModelAndView modelAndView = new ModelAndView("Cart");
        return modelAndView;
    }
}
