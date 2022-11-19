package com.kostkin.DAO;

import com.kostkin.model.Product;

import java.util.List;

public interface ProductDAO {
   Product findById(Long id);
   List<Product> findAll();
   void deleteById(Long id);
   void saveOrUpdate(Product product);
}
