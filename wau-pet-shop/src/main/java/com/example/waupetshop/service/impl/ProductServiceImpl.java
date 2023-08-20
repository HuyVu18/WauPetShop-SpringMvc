package com.example.waupetshop.service.impl;

import com.example.waupetshop.dto.ProductDto;
import com.example.waupetshop.entity.Category;
import com.example.waupetshop.mapper.ProductMapper;
import com.example.waupetshop.repository.ProductRepository;
import com.example.waupetshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAllByCategory(Category category) {
        return productMapper.entitiesToDtos(productRepository.findAllByCategory(category));
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.entityToDto(productRepository.findById(id).orElse(null));
    }
}
