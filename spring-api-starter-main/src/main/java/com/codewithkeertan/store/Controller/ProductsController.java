package com.codewithkeertan.store.Controller;

import com.codewithkeertan.store.DTOS.ProductDto;
import com.codewithkeertan.store.entities.Product;
import com.codewithkeertan.store.mappers.ProductMapper;
import com.codewithkeertan.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductsController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProdcuts(){

        return productRepository.findAll().stream()
                .map(product -> productMapper.toDto(product))
                .toList();
    }



}

