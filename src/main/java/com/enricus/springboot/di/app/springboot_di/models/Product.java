package com.enricus.springboot.di.app.springboot_di.models;

public class Product implements Cloneable{

    private Long id;
    private Long price;
    private String name;
    
    public Product() {
    }
    
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(id, name, price);
        }
    }

    

}
