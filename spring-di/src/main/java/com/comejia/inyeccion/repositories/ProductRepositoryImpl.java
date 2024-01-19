package com.comejia.inyeccion.repositories;

import com.comejia.inyeccion.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository
//@RequestScope // one object per request
//@SessionScope // object is used for session
// For default object is Singleton
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria", 100L),
                new Product(2L, "Disco", 850L),
                new Product(3L, "Teclado", 150L),
                new Product(4L, "Mouse", 50L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
