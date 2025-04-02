 package com.enricus.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.enricus.springboot.di.app.springboot_di.models.Product;
import com.enricus.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    //this class acces data via the repository. it may make things to data or use other repos

    // private ProductRepositoryImpl repo = new ProductRepositoryImpl(); //this attr is shared by all instances or users, because the controller is a singleton
    
    @Autowired
    @Qualifier("productFoo")
    private ProductRepository repo;
    
    // @Autowired
    // public void setRepo(ProductRepository repo) {
        //     this.repo = repo;
        // }
        
    // public ProductServiceImpl(@Qualifier("productList") ProductRepository repo) {
    //     this.repo = repo;
    // } // in constructors is not necessary @autowired
    
    @Override
    public List<Product> findAll() {
        //multiply by a tax
        return repo.findAll().stream().map(p -> { //map generates new list: inmutability
            Double priceTaxed = p.getPrice() * 1.25d;
            // p.setPrice(priceTaxed.longValue()); //this is using the same object: mutability
            //new Product(p.getId(), p.getName(), priceTaxed.longValue());//this fullfills inmutability 
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTaxed.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long Id) {
        return repo.findById(Id);
    }
}
