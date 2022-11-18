package com.kostkin.service;

import com.kostkin.DAO.ProductDAO;
import com.kostkin.DAO.ProductDAOImpl;
import com.kostkin.model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO service = new ProductDAOImpl();

    @Override
    public Product findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return service.findAll();
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public void saveOrUpdate(Product product) {
        service.saveOrUpdate(product);
    }
}
