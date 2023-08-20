package com.example.waupetshop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_line")
public class CartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Category.class)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Category.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotBlank
    @Column(name = "quantity", length = 255, nullable = false)
    private Long quantity;

    @NotBlank
    @Column(name = "sub_price", nullable = false)
    private Long subPrice;

    @NotBlank
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDelete;

}
