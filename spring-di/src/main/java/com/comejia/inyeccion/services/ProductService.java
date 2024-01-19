package com.comejia.inyeccion.services;

import com.comejia.inyeccion.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);
}
