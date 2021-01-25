package ru.geekbrains.mappers;

import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.model.Product;

public class ProductDtoMapper {

    static  public  ProductDto getProductDto(Product product){

        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

    public static Product getProduct(ProductDto productDto) {
        return new Product(productDto.getId(),productDto.getName(), productDto.getPrice());
    }
}
