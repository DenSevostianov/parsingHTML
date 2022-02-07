package ru.den.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class HibernateSession {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {

            sessionFactory = new Configuration().configure( new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
            System.out.println("SessionFactory is created");

            return sessionFactory;

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
