package com.kostkin.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static volatile StandardServiceRegistry registry;
    private static volatile SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        SessionFactory localInstance = sessionFactory;
        if (localInstance == null) {
            synchronized (HibernateUtil.class) {
                localInstance = sessionFactory;
                if (localInstance == null) {
                    try {
                        registry = new StandardServiceRegistryBuilder().configure().build();
                        MetadataSources sources = new MetadataSources(registry);
                        Metadata metadata = sources.getMetadataBuilder().build();
                        localInstance = sessionFactory = metadata.buildSessionFactory();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (registry != null) {
                            StandardServiceRegistryBuilder.destroy(registry);
                        }
                    }
                }
            }
        }
        return localInstance;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
