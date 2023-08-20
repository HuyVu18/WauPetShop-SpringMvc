package com.example.waupetshop.service.impl;

import com.example.waupetshop.entity.Cart;
import com.example.waupetshop.repository.CartRepository;
import com.example.waupetshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public Cart findById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Long userId) {
        Cart cart = Cart
                .builder()
                .userId(userId)
                .totalPrice(0L)
                .build();
        cartRepository.save(cart);
    }
}
