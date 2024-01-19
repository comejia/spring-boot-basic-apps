package com.comejia.inyeccion.repositories;

import com.comejia.inyeccion.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(Long id);
}
