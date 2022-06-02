package ru.gb;

import org.springframework.stereotype.Component;

@Component
public interface ProductsRepository {
    Product findById(Long id);
}
