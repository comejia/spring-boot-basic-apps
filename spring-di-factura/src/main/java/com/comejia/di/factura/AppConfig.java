package com.comejia.di.factura;

import com.comejia.di.factura.models.Item;
import com.comejia.di.factura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Primary
    @Bean
    public List<Item> invoiceItems() {
        return Arrays.asList(
                new Item(new Product("Camera", 100), 2),
                new Item(new Product("Monitor", 1000), 5)
        );
    }

    @Bean
    public List<Item> invoiceOfficeItems() {
        return Arrays.asList(
                new Item(new Product("Mother", 500), 3),
                new Item(new Product("Procesador", 1000), 6),
                new Item(new Product("Ram", 200), 2)
        );
    }
}
