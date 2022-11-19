package com.kostkin.DAO;

import com.kostkin.config.HibernateUtil;
import com.kostkin.model.Customer;
import com.kostkin.model.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer findById(Long id) {
        Customer customer = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            customer = session.get(Customer.class, id);
            session.getTransaction().commit();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Customer> query = session.createQuery("from Customer", Customer.class);
            customers = query.getResultList();
            session.getTransaction().commit();
        }
        return customers;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void addProductToCustomer(Long customerId, Product product) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            customer.getProducts().add(product);
            session.getTransaction().commit();
        }
    }
}
