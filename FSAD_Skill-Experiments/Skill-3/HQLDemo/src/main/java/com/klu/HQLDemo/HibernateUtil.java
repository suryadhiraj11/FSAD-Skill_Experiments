package com.klu.HQLDemo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
  private static SessionFactory sessionFactory;

    // Static block initializes SessionFactory when class is loaded
    static {
        try {
            // Build ServiceRegistry from configuration file
            StandardServiceRegistry ssr =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();

            // Create Metadata from ServiceRegistry
            Metadata metadata =
                    new MetadataSources(ssr)
                            .getMetadataBuilder()
                            .build();

            // Build SessionFactory from Metadata
            sessionFactory =
                    metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Provides access to SessionFactory for DAO classes
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}