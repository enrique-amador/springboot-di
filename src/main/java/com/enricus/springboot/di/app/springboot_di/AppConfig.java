package com.enricus.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.enricus.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.enricus.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration

@PropertySources({
    @PropertySource(value="classpath:custom.properties", encoding = "UTF-8")
})
public class AppConfig {

    @Bean("productJson") //to create a component when is external (you cannot add @Component to it)
    ProductRepository productRepositoryJson(){ //inject it in constructors with method‘s name: @Qualifier("productRepositoryJson") 
        return new ProductRepositoryJson();
    }
}
