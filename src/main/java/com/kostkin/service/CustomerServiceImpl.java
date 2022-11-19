package com.kostkin.service;

import com.kostkin.DAO.CustomerDAO;
import com.kostkin.model.Customer;
import com.kostkin.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer findById(Long id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public void deleteById(Long id) {
        customerDAO.deleteById(id);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        customerDAO.saveOrUpdate(customer);
    }

    @Override
    public void addProductToCustomer(Long customerId, Product product) {
        customerDAO.addProductToCustomer(customerId, product);

    }
}
