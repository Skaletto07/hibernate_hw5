package com.kostkin;

import com.kostkin.config.HibernateUtil;
import com.kostkin.model.Product;
import com.kostkin.service.ProductService;
import com.kostkin.service.ProductServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ProductService service = new ProductServiceImpl();
            List<Product> all = service.findAll();
            System.out.println(all);

        } finally {
            HibernateUtil.shutdown();
        }
    }
}
