package com.enricus.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.enricus.springboot.di.app.springboot_di.models.Product;

public interface ProductRepository {

    public List<Product> findAll();

    public Product findById(Long id);
}
