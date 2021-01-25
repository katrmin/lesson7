package ru.geekbrains.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.mappers.ProductDtoMapper;
import ru.geekbrains.model.Product;
import ru.geekbrains.repositories.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam(required = false) Integer minPrice, @RequestParam(required = false) Integer maxPrice) {
        List<Product> result = minPrice == null && maxPrice == null ? productRepository.findAll() :
                minPrice != null && maxPrice == null ? productRepository.findAllByPriceGreaterThan(minPrice) :
                        minPrice == null && maxPrice != null ?
                                productRepository.findAllByPriceLessThan(maxPrice):
                                minPrice != null && maxPrice != null ?
                                        productRepository.findAllByPriceBetween(minPrice, maxPrice)
                                        : Collections.emptyList();

        return  result.stream()
                .map(product -> ProductDtoMapper.getProductDto(product)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return ProductDtoMapper.getProductDto(productRepository.findById(id).get());
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {

        Product product = ProductDtoMapper.getProduct(productDto);
        return ProductDtoMapper.getProductDto(productRepository.save(product));
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
