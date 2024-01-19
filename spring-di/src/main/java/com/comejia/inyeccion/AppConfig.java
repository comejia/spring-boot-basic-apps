package com.comejia.inyeccion;

import com.comejia.inyeccion.repositories.ProductRepository;
import com.comejia.inyeccion.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:product.json")
    private Resource resource;

//    @Primary
    @Bean
    public ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson(resource);
    }
}
