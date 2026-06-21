package com.codewithkeertan.store.mappers;

import com.codewithkeertan.store.DTOS.ProductDto;
import com.codewithkeertan.store.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
}
