package com.example.waupetshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin("*")
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping
    public ModelAndView viewCart() {
        ModelAndView modelAndView = new ModelAndView("Order");
        return modelAndView;
    }
}
