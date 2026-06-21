package com.codewithkeertan.store.DTOS;

import com.codewithkeertan.store.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ProductDto {
    private String name;
    private String Description;
    private BigDecimal price;
    private Category category;

}
