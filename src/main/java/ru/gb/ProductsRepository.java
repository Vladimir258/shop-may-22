package ru.gb;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductsRepository {
    Product findById(Long id);
    List<Product> findAll();
}
