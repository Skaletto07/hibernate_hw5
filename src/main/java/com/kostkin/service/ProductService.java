package com.kostkin.service;

import com.kostkin.model.Product;

import java.util.List;


public interface ProductService {
    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    void saveOrUpdate(Product product);
}
