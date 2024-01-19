package com.comejia.inyeccion.repositories;

import com.comejia.inyeccion.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(20L, "Cargador", 1500L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(21L, "Pendrive", 200L);
    }
}
