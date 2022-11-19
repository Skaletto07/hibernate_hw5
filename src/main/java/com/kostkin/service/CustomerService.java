package com.kostkin.service;

import com.kostkin.model.Customer;
import com.kostkin.model.Product;

import java.util.List;

public interface CustomerService {
    Customer findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    void saveOrUpdate(Customer customer);
    void addProductToCustomer(Long customerId, Product product);
}
