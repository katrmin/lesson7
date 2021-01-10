package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(Integer minPrice);

    List<Product> findAllByPriceLessThan(Integer maxPrice);

    List<Product> findAllByPriceBetween(Integer minPrice, Integer maxPrice);
}
