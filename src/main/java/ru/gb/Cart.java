package ru.gb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
@Scope("prototype")
public class Cart {
    private ProductsRepository productsRepository;
    private ArrayList<Product> listProducts = new ArrayList<>();

    @Autowired
    public void setProductsRepository(ProductsRepository repository) {
        this.productsRepository = repository;
    }

    void showCart() {
        System.out.println("Продукты в корзине: ");
        System.out.println();
        for (Product p: listProducts) {
            System.out.println(p.getInfoProduct());
        }
        System.out.println();
    }

    void addById(Long id) {
        listProducts.add(productsRepository.findById(id));
    }

    void deleteById(Long id) {
        int index = -1;
        for (Product p: listProducts) {
            if(Objects.equals(id, p.getId())) {
                index = listProducts.indexOf(p);
            }
        }
        listProducts.remove(index);
    }
}
