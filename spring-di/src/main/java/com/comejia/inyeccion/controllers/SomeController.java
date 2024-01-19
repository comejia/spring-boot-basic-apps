package com.comejia.inyeccion.controllers;

import com.comejia.inyeccion.models.Product;
import com.comejia.inyeccion.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> products() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product product(@PathVariable Long id) {
        return service.findById(id);
    }
}
