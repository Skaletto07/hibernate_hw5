package com.kostkin.DAO;

import com.kostkin.config.HibernateUtil;
import com.kostkin.model.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public Product findById(Long id) {
        Product product = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Query<Product> query = session.createQuery("from Product", Product.class);
            products = query.getResultList();
            session.getTransaction().commit();
        }
        return products;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
