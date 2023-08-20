package com.example.waupetshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartLineDto {
    private Long id;

    private String productName;

    private String type;

    private Long quantity;

    private String subPrice;

    private String imgUrl;
}
