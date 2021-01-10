package ru.geekbrains.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.model.Product;
import ru.geekbrains.repositories.ProductRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) Integer minPrice, @RequestParam(required = false) Integer maxPrice) {
        return minPrice == null && maxPrice == null ? productRepository.findAll() :
                minPrice != null && maxPrice == null ? productRepository.findAllByPriceGreaterThan(minPrice) :
                        minPrice == null && maxPrice != null ? productRepository.findAllByPriceLessThan(maxPrice) :
                                minPrice != null && maxPrice != null ? productRepository.findAllByPriceBetween(minPrice, maxPrice) : Collections.emptyList();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }
}
