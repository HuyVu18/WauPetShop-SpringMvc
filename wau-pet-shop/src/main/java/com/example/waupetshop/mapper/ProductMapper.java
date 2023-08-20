package com.example.waupetshop.mapper;

import com.example.waupetshop.dto.ProductDto;
import com.example.waupetshop.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public List<ProductDto> entitiesToDtos(List<Product> element) {
        return element.stream()
                .map(this::entityToDto)
                .toList();
    }

    public ProductDto entityToDto(Product element) {
        ProductDto result = new ProductDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    public Product dtoToEntity(ProductDto element) {
        Product result = new Product();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}
