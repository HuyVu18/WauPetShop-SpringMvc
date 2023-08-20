package com.example.waupetshop.controller;

import com.example.waupetshop.service.CategoryService;
import com.example.waupetshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@CrossOrigin("*")
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}/detail")
    public ModelAndView viewProductDetail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("Product-detail");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }
}
