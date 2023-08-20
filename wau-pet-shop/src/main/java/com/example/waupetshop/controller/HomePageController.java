package com.example.waupetshop.controller;

import com.example.waupetshop.service.CategoryService;
import com.example.waupetshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@CrossOrigin("*")
@RequestMapping("/home")
@RequiredArgsConstructor
@SessionAttributes("userLogged")
public class HomePageController {
    private final ProductService productService;

    private final CategoryService categoryService;

    @GetMapping
    public ModelAndView showHomePage(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("Home-page");
        model.put("catProducts", productService.findAllByCategory(categoryService.findById(1L)));
        model.put("dogProducts", productService.findAllByCategory(categoryService.findById(2L)));
        model.put("hamsterProducts", productService.findAllByCategory(categoryService.findById(3L)));
        modelAndView.addAllObjects(model);
        return modelAndView;
    }
}
