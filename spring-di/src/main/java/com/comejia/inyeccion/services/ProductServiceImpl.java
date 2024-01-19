package com.comejia.inyeccion.services;

import com.comejia.inyeccion.models.Product;
import com.comejia.inyeccion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment environment;
    @Value("${config.price.multiplier}")
    private Long tax;

//    @Autowired
    private ProductRepository repository; // DI by field

//    @Autowired
//    public void setRepository(ProductRepository repository) { // DI by setter
//        this.repository = repository;
//    }

//    @Autowired // is not necessary in Constructor
    public ProductServiceImpl(ProductRepository repository) { // DI by constructor
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll().stream()
                .map(p -> {
                    Long price = p.getPrice() * tax;// environment.getProperty("config.price.multiplier", Long.class);
//                    Product newProduct = new Product(p.getId(), p.getName(), price); // now is immutable

                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(price);
                    return newProduct;

//                    p.setPrice(price);
//                    return p;
                }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
