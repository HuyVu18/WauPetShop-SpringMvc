package com.example.waupetshop.service;

import com.example.waupetshop.entity.Cart;

public interface CartService {

    Cart findById(Long id);

    void save(Long userId);
}
