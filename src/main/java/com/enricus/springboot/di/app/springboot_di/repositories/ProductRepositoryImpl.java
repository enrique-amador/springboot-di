package com.enricus.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
// import org.springframework.web.context.annotation.SessionScope;

import com.enricus.springboot.di.app.springboot_di.models.Product;

// @RequestScope //With this is no longer a singleton
// @SessionScope//http session,``````` used in web apps
@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    //this class access to data
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria Corsair", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Razer Keyboard", 180L),
            new Product(4L, "Motherboard Gybabyte", 490L)
        );
        //instead of store this as a singleton and when updated is shared by all, its scope is now the request with @RequestScope
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
