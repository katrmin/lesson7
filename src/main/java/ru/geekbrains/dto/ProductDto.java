package ru.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;

    public ProductDto(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
