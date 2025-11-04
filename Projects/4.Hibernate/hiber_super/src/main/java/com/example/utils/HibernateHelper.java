package com.example.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.example.entities.*;

public class HibernateHelper {
    private static SessionFactory sessionFactory;
    //Викликається один раз при завантаженні класу
    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                //.configure() // Завантаження налаштувань з hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(CategoryEntity.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (Exception e){
            System.err.println("Initial SessionFactory creation failed."+ e);
            StandardServiceRegistryBuilder.destroy(registry);
            //e.printStackTrace();

        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        return getSessionFactory().openSession();
    }

    public static void shutdown(){
        if (sessionFactory != null)
            getSessionFactory().close();
    }

}
