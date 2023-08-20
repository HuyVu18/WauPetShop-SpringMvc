package com.example.waupetshop.service;

import com.example.waupetshop.dto.ProductDto;
import com.example.waupetshop.entity.Category;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllByCategory(Category category);

    ProductDto findById(Long id);


}
