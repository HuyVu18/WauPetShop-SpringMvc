package com.example.waupetshop.repository;

import com.example.waupetshop.entity.Cart;
import com.example.waupetshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
