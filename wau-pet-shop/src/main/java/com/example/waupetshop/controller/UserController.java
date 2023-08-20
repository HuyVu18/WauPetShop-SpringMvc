package com.example.waupetshop.controller;

import com.example.waupetshop.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("Login");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logoutPage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("Login");
        session.removeAttribute("userLogged");
        return modelAndView;
    }
}
