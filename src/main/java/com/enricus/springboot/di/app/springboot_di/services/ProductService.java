package com.enricus.springboot.di.app.springboot_di.services;

import java.util.List;

import com.enricus.springboot.di.app.springboot_di.models.Product;

public interface ProductService {

    public List<Product> findAll();

    public Product findById(Long id);
}
