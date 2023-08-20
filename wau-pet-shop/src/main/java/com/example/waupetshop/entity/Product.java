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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @NotBlank
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @NotBlank
    @Column(name = "type", length = 255, nullable = false)
    private String type;

    @NotBlank
    @Column(name = "price", nullable = false)
    private Long price;

    @NotBlank
    @Column(name = "url_img", length = 255, nullable = false)
    private String urlImg;

    @OneToMany(targetEntity = CartLine.class)
    private List<CartLine> cartLines;
}
