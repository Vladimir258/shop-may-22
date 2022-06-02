package ru.gb;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Primary
public class InMemProductsRepository implements ProductsRepository {
    private List<Product> products;

    {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 30f),
                new Product(2L, "Milk", 15f),
                new Product(3L, "Apples", 20f),
                new Product(4L, "Lemon", 10f),
                new Product(5L, "Potato", 12f)
        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
