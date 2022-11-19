package com.kostkin;

import com.kostkin.config.HibernateUtil;
import com.kostkin.model.Customer;
import com.kostkin.model.Product;
import com.kostkin.service.CustomerService;
import com.kostkin.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.kostkin");) {
            ProductService productService = context.getBean(ProductService.class);
            CustomerService customerService = context.getBean(CustomerService.class);
            List<Product> all = productService.findAll();
            System.out.println(all);
            Product product = productService.findById(1L);
            System.out.println(product);

            customerService.addProductToCustomer(1L, product);
            List<Customer> all1 = customerService.findAll();
            System.out.println(all1);
            System.out.println(product);

        } finally {
            HibernateUtil.shutdown();
        }
    }
}
